public int indexOf(Object obj) {
    int index = 0;
    Node<E> current = head;

    while (current != null) {
        if (current.equals(obj)) {
            return index;
        }
        index++;
        current = current.next;
    }

    return -1;
}