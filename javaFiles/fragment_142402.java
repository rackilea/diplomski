public E set(int index, E element) throws IndexOutOfBoundsException {
    if (index < 0) {
        throw new IndexOutOfBoundsException();
    }

    if (index >= size) {
        throw new IndexOutOfBoundsException();
    }

    int i = 0;
    Node tempNode = head;

    while (i < index)
    {
        tempNode = tempNode.getmNextNode();
        i++;
    }

    E previousElement = tempNode.getmElement();
    tempNode.setmElement(element);

    return previousElement;
}