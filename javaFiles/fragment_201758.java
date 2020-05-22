public void addValue(Key key, Value value) {
    boolean added = myMap.computeIfAbsent(key, k -> new HashSet<>()).add(value);
    if (!added) {
        throw new IllegalArgumentException("Association exists already");
    }
}