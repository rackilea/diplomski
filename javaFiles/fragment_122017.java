static <V> List<V> getValues(Map<MultiKey, V> map, Object key1) {
  List<V> values = new ArrayList<>();
  for (Map.Entry<MultiKey, V> entry : map.entrySet()) {
    MultiKey key = entry.getKey();
    if (key.getKey(0).equals(key1)) {
      values.add(entry.getValue());
    }
  }
  return values;
}