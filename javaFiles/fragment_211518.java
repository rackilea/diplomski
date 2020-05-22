public static class ListExtractor<K, V> {

    List<V> list = new ArrayList<>();

    public ListExtractor(List<V> list) {
        this.list = list;
    }

    public Map<K, List<V>> extract(Extractor<K, V> extractor) {
        Map<K, List<V>> res = new HashMap<K, List<V>>();

        for (V v : list) {
            K key = extractor.getKey(v);
            if (!res.containsKey(key))
                res.put(key, new ArrayList<V>());
            res.get(key).add(v);
        }

        return res;
    }
}

public static interface Extractor<K, V> {
    public K getKey(V v);
}