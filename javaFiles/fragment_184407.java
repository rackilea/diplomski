public void undo() {
    if (undoStack.isEmpty()) {
        throw new NoSuchElementException("Undo history is empty");
    } else {
        Node<T> object = undoStack.topAndPop();
        redoStack.push(object);

        object.prev.next = object.next;
        object.next.prev = object.prev;

        theSize--;
        modCount--;
        countUndone++;
    }
}