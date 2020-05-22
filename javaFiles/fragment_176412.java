private <K, V> V getValueIfKeyContains(final Map<List<K>, V> map, final K desiredKey) {
    for (final Entry<List<K>, V> entry : map.entrySet()) {
        if (entry.getKey().contains(desiredKey)) {
            return entry.getValue();
        }
    }
    return null;
}