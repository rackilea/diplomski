public static <K, V> Map<K, V> immutableChainView(
    Iterable<? extends Map<? extends K, ? extends V>> maps) {
  return StreamSupport.stream(maps.spliterator(), false).reduce(
    (Map<K,V>)ImmutableMap.<K,V>of(),
    (a, b) -> Maps.asMap(Sets.union(a.keySet(), b.keySet()),
                         k -> a.containsKey(k) ? a.get(k) : b.get(k)),
    (a, b) -> Maps.asMap(Sets.union(a.keySet(), b.keySet()),
                         k -> a.containsKey(k) ? a.get(k) : b.get(k)));
    }