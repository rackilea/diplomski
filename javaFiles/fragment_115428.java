public Iterator<E> iterator(int index) {
    Iterator<E> iterator = iterator();
    for (int i = 0; i < index && iterator.hasNext(); i++) {
        iterator.next();
    }
    return iterator;
}