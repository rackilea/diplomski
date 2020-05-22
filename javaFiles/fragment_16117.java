public V put(K key, V value) {
  ...
  int hash = hash(key);
  int i = indexFor(hash, table.length);
  for (Entry<K,V> e = table[i]; e != null; e = e.next) {
    Object k;
    if (e.hash == hash && ((k = e.key) == key || key.equals(k))) {
      // Replace existing element and return
    }
  }
  // Insert new element
}