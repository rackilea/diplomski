<K, V> V ensureEntry(ConcurrentMap<K, V> map, K key, Supplier<V> factory) {
    V result = map.get(key);
    if (result == null) {
        V value = factory.get();
        result = map.putIfAbsent(key, value);
        if (result == null) {
            result = value;
        }
    }
    return result;
}

ConcurrentMap<String, AtomicReference<Object>> map = new ConcurrentHashMap<>();
ensureEntry(map, "key", () -> new AtomicReference<>());
// or
ensureEntry(map, "key", AtomicReference::new);