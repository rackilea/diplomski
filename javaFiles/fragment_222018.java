@Override

public DBObject next() {
    checkIteratorOrArray(IteratorOrArray.ITERATOR);
    if (!hasNext()) {
        throw new NoSuchElementException();
    }

    return nextInternal();
}