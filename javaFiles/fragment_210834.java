<K, V> K getKey(LinkedHashMap<K, V> map, int index) {
    Iterator<K> itr = map.keySet().iterator();
    for (int i = 0; i < index; i++) {
        itr.next();
    }
    return itr.next();
}