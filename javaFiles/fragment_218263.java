public void put(K key, V val) {
  Iterator<Map.Entry<K, V>> entries = entrySet().iterator();
  while (entries.hasNext()) {
    if (entries.next().getValue().equals(val)) {
      entries.remove();
      break;
    }
  }
  super.put(key, val);
}