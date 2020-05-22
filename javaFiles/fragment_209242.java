public E get(int index) {
    // TODO: Implement this method.
    LLNode<E> current = head;
    for (int i = 0; i <= index; i++) {
        if (current != null) {
            current = current.next;
        } else {
            throw new IndexOutOfBoundsException();
        }

    }
    return current.data;
}