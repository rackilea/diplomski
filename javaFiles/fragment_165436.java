class LinkedList<E> {
    ...

    private LinkedList(E value, LinkedList<E> tail) {
        this.data = value;
        this.tail = tail;
    }

    public LinkedList<E> prependItem(E item) {
        return new LinkedList(item, this);
    }
}