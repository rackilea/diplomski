public E pop() throws NoSuchElementException {
    if (size == 0) {
        throw new NoSuchElementException();
    }
    E previousHeadValue = head.item;
    head = head.next;
    size--;
    return previousHeadValue;
}