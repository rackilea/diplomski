class KeySet implements Set<K> {
  private final Map<K, V> map;

  public boolean contains(Object o) {
    return map.containsKey(o);
  }

  ...
}