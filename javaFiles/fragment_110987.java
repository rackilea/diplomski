@Override
public void putAll(Map<? extends K, ? extends V> m) {
  Iterator<? extends K> iterator = m.keySet().iterator();
  while (iterator.hasNext()) {
    K key = iterator.next();
    put(key, m.get(key));
  }
}