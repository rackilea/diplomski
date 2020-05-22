public static <K1, K2, V> Map<K1, V> java7Version(Map<K1, K2> first, Map<K2, V> second) {
  HashMap<K1, V> result = new HashMap<>(Math.min(first.size(), second.size()));
  for (Map.Entry<K1, K2> entry : first.entrySet()) {
    if (second.containsKey(entry.getValue()))
      result.put(entry.getKey(), second.get(entry.getValue()));
  }
  return result;
}