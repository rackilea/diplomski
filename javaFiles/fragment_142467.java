public static 
<K, V extends Comparable<? super V>, T extends Comparable<? super T>>
Collection<K> 
topN(
        Map<K, V> map, 
        int N,
        Function<? super K, ? extends T> tieBreaker) {

    TreeMap<Map.Entry<K, V>, K> topN = new TreeMap<>(
        Map.Entry.<K, V>comparingByValue()      // by value descending, then by key
            .reversed()                         // to allow entries with duplicate values
            .thenComparing(e -> tieBreaker.apply(e.getKey())));

    map.entrySet().forEach(e -> {
      topN.put(e, e.getKey());
      if (topN.size() > N) topN.pollLastEntry();
    });

    return topN.values();
}