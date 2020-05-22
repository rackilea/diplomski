static <K, V extends Comparable<? super V>> TreeMap<K, V> entriesSortedByValues(final Map<K, V> map) {
    TreeMap<K, V> sortedEntries = new TreeMap<K, V>(new Comparator<K>() {
      @Override
      public int compare(K o1, K o2) {
        return map.get(o1).compareTo(map.get(o2));
      }
    });
    sortedEntries.putAll(map);
    return sortedEntries;
}