public V put(K key, V value) {
    [...]
    modCount++;
    addEntry(hash, key, value, i);
    return null;
}