import static java.util.stream.Collectors.*;
.....

Map<Class<? extends Animal>, Long> animalCounts = animals.stream()
        .flatMap(
                lst -> lst.stream()
                    .map(a -> a.getClass())
                    .distinct()   // in case several of the same animal are in the same place
        )
        .collect(groupingBy(x -> x, counting()));

List<Class<? extends Animal>> animalTypes = animalCounts.entrySet().stream()
        .filter(e -> e.getValue() > 1)
        .map(Map.Entry::getKey)
        .collect(toList());