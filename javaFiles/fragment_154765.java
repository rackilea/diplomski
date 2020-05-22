private class Itr implements Iterator<E> {
    int cursor;       // index of next element to return
    int lastRet = -1; // index of last element returned; -1 if no such

    public E next() {
        checkForComodification();
        int i = cursor;
        if (i >= size) throw new NoSuchElementException();
        // ...
        cursor = i + 1;
        return (E) elementData[lastRet = i];
    }

    public void remove() {
        // ...
        ArrayList.this.remove(lastRet);
        // ...
        cursor = lastRet;
        lastRet = -1;
    }