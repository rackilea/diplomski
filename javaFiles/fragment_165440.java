public LinkedList<E> reverse() {
    if (tail == null) {
        return this;
    } else {
        LinkedList<E> list = reverse(tail);
        tail.tail = this;
        tail = null;
        return list;
    }
}