private class ListItr extends Itr implements ListIterator<E> {
ListItr(int index) {
    cursor = index;
}

// [...]