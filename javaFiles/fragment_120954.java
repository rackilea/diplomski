public boolean remove(T item) {
    Iterator<T> iter = bag.iterator();
    while (iter.hasNext()) {
        T i = iter.next();
            if (i.equals(item)) {
                iter.remove();
                return true;
            }
    }
    return false;
}