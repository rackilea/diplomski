public static <K, V> Map<K, Integer> getNumOfValuesPerKey(Map<K, List<V>> map) {

    Map<K, Integer> count = new HashMap<K, Integer>();

    for (Entry<K, List<V>> entry : map.entrySet()) 
        count.put(entry.getKey(), entry.getValue().size());

    return count;
}