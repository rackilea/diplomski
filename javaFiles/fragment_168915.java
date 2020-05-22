private class ListIterator implements Iterator<V> {
    private Node next;
    private boolean alreadyDeleted = false;

    ListIterator(Node node){
        this.next = node;
    }

    @Override
    public boolean hasNext() {
        // because next is the current element. We need to iterate over all the elements
        // from the collection.
        return next != null;
    }

    @Override
    public V next() {
        if (next == null) {
           throw new NoSuchElementException();
        }

        Node current = next;

        this.next = current.getNext();
        this.alreadyDeleted = false; // it's better to try to elimate this state variable. You can try to do in another way, if yours removeElement returns something

        return current;
    }

    @Override
    public void remove() {
        if (alreadyDeleted || next == null) {
           throw new IllegalStateException();
        }
        removeElement(next.getReprKey());
        this.alreadyRemoved = true;
    }

}