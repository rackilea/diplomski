public class Unique {
  // despite being final this is not a "constant" because it's mutable
  private static final AtomicInteger counter = new AtomicInteger();
  private final int id;

  public Unique() {
    id = counter.getAndIncrement();
  }

  @Override public String toString() { return "ID: " + id; }
}