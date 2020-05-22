static <K, V> Map<K, V> initialiseMap(Pair<K, V>... entries) {
    Map<K, V> temp = new HashMap<K, V>();
    for (Pair<K, V> pair : entries) {
        temp.put(pair.first(), pair.second());
    }
    return temp;
}