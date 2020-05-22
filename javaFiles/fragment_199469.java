public class Deques {
  private Deques() {}

  public static <T> Iterable<T> asDescendingIterable(final Deque<T> deque) {
    return new Iterable<T>() {
      public Iterator<T> iterator() {
        return deque.descendingIterator();
      }
    }
  }
}