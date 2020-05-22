private LinkedList(E value) {
    this.data = value;
    this.tail = null;
}

public void appendItem(E item) {
    LinkedList<E> list = this;
    while (list.tail != null)
        list = list.tail;
    list.tail = new LinkedList<>(item);
}