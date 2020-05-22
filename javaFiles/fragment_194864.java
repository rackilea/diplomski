public class MapCollector {
    private final Map<Set<String>,Set<Integer>> result = new HashMap<>();

    public void accept(Map.Entry<String,Set<Integer>> entry) {
        Set<String> key = new HashSet<>(Arrays.asList(entry.getKey()));
        Set<Integer> value = new HashSet<>(entry.getValue());
        Set<Set<String>> overlapKeys = result.entrySet().stream()
                .filter(e -> e.getValue().stream().anyMatch(value::contains))
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
        overlapKeys.stream().forEach(key::addAll);
        overlapKeys.stream().map(result::get).forEach(value::addAll);
        result.keySet().removeAll(overlapKeys);
        result.put(key, value);
    }

    public MapCollector combine(MapCollector other) {
        other.result.forEach(this::accept);
        return this;
    }

    public static Collector<Map.Entry<String, Set<Integer>>, MapCollector, Map<Set<String>,Set<Integer>>> collector() {
        return Collector.of(MapCollector::new, MapCollector::accept, MapCollector::combine, c -> c.result);
    }
}