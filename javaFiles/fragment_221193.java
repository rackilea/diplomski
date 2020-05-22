@SuppressWarnings("unchecked")
public static <K, V> Map<K, V> mapOf(K key, V value, Object... morePairs) {
    Map<K, V> map = new HashMap<K, V>();
    map.put(key, value);
    for (int i=0; i<morePairs.length; i+=2) {
        map.put((K)morePairs[i], (V)morePairs[i+1]);
    }
    return map;
}