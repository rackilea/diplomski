public interface Supplier<T> {
  public int size();

  public T get(int index);

}

public interface PairSupplier<Q, E> extends Supplier<Pair<Q, E>> {
}

public class IterableSupplier<T> implements Iterable<T> {
  // The common supplier to use across all threads.
  final Supplier<T> supplier;
  // The atomic counter.
  final AtomicInteger i = new AtomicInteger();

  public IterableSupplier(Supplier<T> supplier) {
    this.supplier = supplier;
  }

  @Override
  public Iterator<T> iterator() {
    /**
     * You may create a NEW iterator for each thread while they all share supplier
     * and Will therefore distribute each Pair between different threads.
     *
     * You may also share the same iterator across multiple threads.
     *
     * No two threads will get the same pair twice unless the sequence cycles.
     */
    return new ThreadSafeIterator();
  }

  private class ThreadSafeIterator implements Iterator<T> {
    @Override
    public boolean hasNext() {
      /**
       * Always true.
       */
      return true;
    }

    private int pickNext() {
      // Just grab one atomically.
      int pick = i.incrementAndGet();
      // Reset to zero if it has exceeded - but no spin, let "just someone" manage it.
      int actual = pick % supplier.size();
      if (pick != actual) {
        // So long as someone has a success before we overflow int we're good.
        i.compareAndSet(pick, actual);
      }
      return actual;
    }

    @Override
    public T next() {
      return supplier.get(pickNext());
    }

    @Override
    public void remove() {
      throw new UnsupportedOperationException("Remove not supported.");
    }

  }

}