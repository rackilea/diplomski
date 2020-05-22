public class Customer {
  private static AtomicInteger nextId = new AtomicInteger(0);
  private static String getNextId() {
    return Integer.toString(nextId.incrementAndGet());
  }
  public Customer(...) {
    id = getNextId();
    ...
  }
}