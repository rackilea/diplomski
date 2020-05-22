public void add(K key, V value) {
    concurrentMap.put(key, value);
    queue.add(key);
}

public V poll() {
    for(K key; (key = queue.take()) != null;) {
        V value = concurrentMap.remove(key);
        if (value != null)
           return value;
        // value will be null if it's a duplicate so ignore and look for more.
    }
    return null;
}