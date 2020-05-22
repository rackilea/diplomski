public V put(K key, V value) {
     Entry<K,V> t = root;

    if (t == null) {
  + if (key == null) {
  + if (comparator == null)
  + throw new NullPointerException();
  + comparator.compare(key, key);
  + }
         incrementSize();
         root = new Entry<K,V>(key, value, null);
         return null;
     }