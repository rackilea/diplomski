public boolean hasSameKey(Map<Key, List<Value>> map, Value... values) {

    for (Key key: map.keySet()) {
        if (map.get(key).containsAll(Arrays.asList(values))) {
            return true;
        }
    }
    return false;
}