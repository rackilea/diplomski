public static <K, V> Map<K, V> createMap(Map<K, V> m) {
    Map<K, V> map = new HashMap<K, V>();
    Map<V, K> tmpMap = new HashMap<V, K>();
    for(Map.Entry<K, V> entry : m.entrySet()) {
        if (!tmpMap.containsKey(entry.getValue())) {
            tmpMap.put(entry.getValue(), entry.getKey());
        }
    }
    for(Map.Entry<V, K> entry : tmpMap.entrySet()) {
        map.put(entry.getValue(), entry.getKey());
    }
    return map;
}