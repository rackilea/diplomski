public class BasicMultiMap<K, V> {
    private Map<K, List<V>> map = new HashMap<>();
    public void put(K key, V value) {
        List<V> list = map.get(key);
        if (list == null) {
            list = new ArrayList<>();
            map.put(key, list);
        }
        list.add(value);
    }
    public List<V> get(K key) {
        return map.get(key);
    }
}