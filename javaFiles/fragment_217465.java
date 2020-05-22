public static <K1, K2, V> Map<K1, V> java8VersionWithNulls(Map<K1, K2> first, Map<K2, V> second, boolean keepNulls) {
  return first.entrySet()
    .stream()
    .filter(e -> keepNulls || second.containsKey(e.getValue()))
    .collect(Collectors.toMap(Map.Entry::getKey, e -> second.get(e.getValue())));
}

public static <K1, K2, V> Map<K1, V> java7VersionWithNulls(Map<K1, K2> first, Map<K2, V> second, boolean keepNulls) {
  HashMap<K1, V> result = new HashMap<>(second.size());
  for (Map.Entry<K1, K2> entry : first.entrySet()) {
    if (keepNulls || second.containsKey(entry.getValue()))
      result.put(entry.getKey(), second.get(entry.getValue()));
  }
  return result;
}