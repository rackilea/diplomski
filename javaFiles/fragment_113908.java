public class Foo {
  public static void main(String[] args) {
    class CloseTest implements AutoCloseable {
      public void close() {
        System.out.println("Close");
      }
    }
    try (CloseTest closeable = new CloseTest()) {}
  }
}