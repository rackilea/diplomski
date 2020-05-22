// case 1
for (final Map.Entry<K, V> entry: map.entrySet()) {
    // entry.getKey(), entry.getValue()
}

// case 2
for (final K key: map.keySet()) {
    V value = map.get(key);
}