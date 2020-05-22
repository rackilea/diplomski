private class Itr implements Iterator<E> {
  /**
   * The modCount value that the iterator believes that the backing
   * Queue should have.  If this expectation is violated, the iterator
   * has detected concurrent modification.
   */
  private int expectedModCount = modCount;

  public E next() {
    if(expectedModCount != modCount) {
      throw new ConcurrentModificationException();
    }


  }

}