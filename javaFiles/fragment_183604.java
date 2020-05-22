public static <K, V> Map<K, V> newMap(K key1, V value1, Object... kvs) {
    Map<K, V> m = new HashMap<>();
    m.put(key1, value1);
    addToMap(map, kvs);
    return m;
}

private static <K, V> void addToMap(Map<K,V> map, Object[] kvs) {
    for(int i = 0; i < kvs.length; i++) {
        Object key = kvs[i];
        if (key instanceof Object[]) {
           addToMap(map, (Object[]) key);
        } else if (++i < kvs.length) {
           map.put((K) key, (V) kvs[i]);
        }
    }
}