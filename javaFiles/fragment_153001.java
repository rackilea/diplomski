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
            T left = getLeft();
            if(left == null) throw new ConcurrentModificationException();
            return left;
        }
        else if(hasPendingRight) {
            hasPendingRight = false;
            T right = getRight();
            if(right == null) throw new ConcurrentModificationException();
            return right;
        }
        throw new NoSuchElementException();
    }
}