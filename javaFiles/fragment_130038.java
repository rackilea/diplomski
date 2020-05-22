public LinkedHashMap<String, Integer> getTop5ByValue(LinkedHashMap<String, Integer> map) {
    AtomicInteger index = new AtomicInteger();
    return map.entrySet().stream()
        .sorted(Entry.<String, Integer> comparingByValue().reversed())
        .limit(5)
        .collect(
            Collectors.toMap(
                e -> e.getKey(),
                e -> index.getAndIncrement(),
                (k, v) -> {
                    throw new IllegalStateException("Duplicate key " + k);
                },
                LinkedHashMap::new)
            );
}