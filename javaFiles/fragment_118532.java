import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.toMap;

Map<String, List<String>> sorted = map.entrySet().stream()
    .sorted(comparingInt(e -> e.getValue().size()))
    .collect(toMap(
        Map.Entry::getKey,
        Map.Entry::getValue,
        (a, b) -> { throw new AssertionError(); },
        LinkedHashMap::new
    ));