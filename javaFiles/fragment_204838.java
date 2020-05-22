public static <K, V extends Comparable> Map<K, V> sortByValues(Map<K, V> tempMap) {
  TreeMap<K, V> map = new TreeMap<>(buildComparator(tempMap));
  map.putAll(tempMap);
  return map;
}

public static <K, V extends Comparable> Comparator<? super K> buildComparator(final Map<K, V> tempMap) {
  return (o1, o2) -> tempMap.get(o1).compareTo(tempMap.get(o2));
}