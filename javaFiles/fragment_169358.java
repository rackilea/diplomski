public V get(K key) {
    int pos = keys.indexOf(key);
    if(pos < 0)
        return null;
    return values.get(pos);
}