class ReadOnlyMap<K, V> {

    private final Map<K, V> map;

    public ReadOnlyMap(Map<K, V> map) {
       this.map = map;
    }

    public V get(Object key) {
        return map.get(key);
    }

    // also implement size() method
    // and everything else you want to expose
}