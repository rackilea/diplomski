private static <K, V extends Comparable<V>> Map<K, V> orderByDescValue(Map<K, V> unorderedMap) {
    return unorderedMap.entrySet().stream()
        .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
        .collect(Collectors.toMap(
            Map.Entry::getKey,
            Map.Entry::getValue,
            (x, y) -> { throw new IllegalStateException("Unexpected merge request"); },
            LinkedHashMap::new));
}