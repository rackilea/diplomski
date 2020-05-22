public List<V> getOrAdd(K key) {
    if (containsKey(key)) {
        return get(key);
    } else {
        List<V> l = new ArrayList<V>();
        put(key, l);
        return l;
    }
}