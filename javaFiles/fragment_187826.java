private boolean removeInternal(Object o) {
    for (int i = 0; i < currentSize; ++i) {
        T elt = get(i);
        if (o == null ? elt == null : o.equals(elt)) {
            removeElementAtPosition(i);
            deletedItems.add(elt);
            return true;
        }
        return false;
    }
}