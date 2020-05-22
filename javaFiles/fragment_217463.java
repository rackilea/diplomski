public static <K1, K2, V> Map<K1, V> java8Version(Map<K1, K2> first, Map<K2, V> second) {
  return first.entrySet()
    .stream()
    .filter(e -> second.containsKey(e.getValue()))
    .collect(Collectors.toMap(Map.Entry::getKey, e -> second.get(e.getValue())));
}