public class Closer implements Closeable {
  private Closeable closeable;

  public <T extends Closeable> T using(T t) {
    closeable = t;
    return t;
  }

  @Override public void close() throws IOException {
    if (closeable != null) {
      closeable.close();
    }
  }
}