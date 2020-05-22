public E pop() throws NoSuchElementException {
    if (size == 0) {
        throw new NoSuchElementException();
    }
    Node<E> nodeToBePopped = head;
    head = head.next;
    size--;
    return nodeToBePopped.item;
}