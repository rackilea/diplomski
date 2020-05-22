static <K, V> void multiMapAdd(ChronicleMap<K, Set<V>> map, K key, V value) {
    map.compute(key, (k, v) -> {
        if (v == null)
            v = new HashSet<>();
        v.add(value);
        return v;
    });
}