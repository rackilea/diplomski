// Warning: completely untested
public final class Multimap<K, V> {
    private final Map<K, List<V>> map = new HashMap<>();

    public void add(K key, V value) {
        List<V> list = map.get(key);
        if (list == null) {
            list = new ArrayList();
            map.put(key, list);
        }
        list.add(value);
    }

    public Iterable<V> getValues(K key) {
        List<V> list = map.get(key);
        return list == null ? Collections.<V>emptyList()
                            : Collections.unmodifiableList(list);
    }
}