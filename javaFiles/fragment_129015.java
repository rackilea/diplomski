public E get(int index) throws IndexOutOfBoundsException {
    Node<E> tempNode = head;
    if (index < 0 || index >= size) {
        throw new IllegalArgumentException("index was out of bounds");
    }
    for (int i = 0; i < index; i++) {
        tempNode = tempNode.getmNextNode();
    }
    return tempNode.getmElement();
}