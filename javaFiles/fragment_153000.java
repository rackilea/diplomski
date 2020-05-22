final class myIterator implements Iterator<T> { // no need to make this public
    boolean hasPendingLeft = getLeft() != null, hasPendingRight = getRight() != null;

    @Override
    public boolean hasNext() {
        return hasPendingLeft || hasPendingRight;
    }

    @Override
    public T next() {
        if(hasPendingLeft) {
            hasPendingLeft = false;
            return getLeft();
        }
        else if(hasPendingRight) {
            hasPendingRight = false;
            return getRight();
        }
        throw new NoSuchElementException();
    }
}