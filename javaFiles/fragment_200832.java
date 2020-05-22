private class ListItr implements ListIterator<E> {
   //...
   public E next() {
      checkForComodification();
      if (nextIndex == size)
      throw new NoSuchElementException();

      lastReturned = next;
      next = next.next;
      nextIndex++;
      return lastReturned.element;
  }
  final void checkForComodification() {
      if (modCount != expectedModCount)
         throw new ConcurrentModificationException();
  }