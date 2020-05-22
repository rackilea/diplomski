public class UberIterable<T> implements Iterable<T> {
  private final List<List<T>> lists;
  public UberIterable(List<T>... lists) {
    this.lists = Arrays.asList(lists); 
  }
  public Iterator<T> iterator() {
    return new Iterator<T>() {
      Iterator<List<T>> metaNext = lists.iterator();
      Iterator<T> next;
      public boolean hasNext() {
        while (true) {
          if (next != null && next.hasNext()) return true;
          if (metaNext.hasNext()) next = metaNext.next(); else return false; 
        }
      }
      public T next() {
        if (!hasNext()) throw new NoSuchElementException();
        return next.next();
      }
      public void remove() {
        throw new UnsupportedOperation();
      }
    }
  }
}