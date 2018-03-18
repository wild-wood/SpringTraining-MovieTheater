package org.maksim.training.mtapp.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.collect.Sets;
import lombok.Builder;
import lombok.Value;
import lombok.experimental.NonFinal;
import org.maksim.training.mtapp.entity.serializer.json.AuditoriumDeserializer;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Builder
@Value
@JsonDeserialize(using = AuditoriumDeserializer.class)
public class Auditorium {
    String name;
    int numberOfSeats;
    @Builder.Default @NonFinal Set<Integer> vipSeats = Sets.newLinkedHashSet();

    public int countVipSeats(Collection<Integer> seats) {
        return seats.stream().filter(vipSeats::contains).collect(Collectors.toList()).size();
    }

    public Collection<Integer> getAllSeats() {
        return IntStream.range(1, numberOfSeats + 1).boxed().collect(Collectors.toList());
    }
}