public V put(K key, V value) {
    if (key == null)
        return putForNullKey(value);
    int hash = hash(key.hashCode());
    int i = indexFor(hash, table.length);
    if (table[i] != null) {
        // TODO: there's already something in this bucket
    }
    for (Entry<K,V> e = table[i]; e != null; e = e.next) {
        ...