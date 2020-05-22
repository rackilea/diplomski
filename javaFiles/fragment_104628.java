public class Twr {
  private static class TwrCloseable implements AutoCloseable {
    private final String id;

    TwrCloseable(String id) {
      this.id = id;
    }

    @Override
    public void close() {
      System.out.println("closing " + id);
    }
  }

  public static void main(String[] args) {
    try (TwrCloseable closeable1 = new TwrCloseable("first");
         TwrCloseable closeable2 = new TwrCloseable("second")) {
      throw new OutOfMemoryError();
    }
  }
}