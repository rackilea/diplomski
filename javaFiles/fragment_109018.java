public E next() {
        checkForComodification();
    try {
    E next = get(cursor);
    lastRet = cursor++;
    return next;
    } catch (IndexOutOfBoundsException e) {
    checkForComodification();
    throw new NoSuchElementException();
    }
}