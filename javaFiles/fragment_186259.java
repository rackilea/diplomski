public boolean collectionContains(Collection<?> collection, Object toCompareTo) {
    for (Object o : collection) {
        if (toCompareTo.equals(o)) return true;
    }
    return false;
}