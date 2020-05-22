public final class ByteArrayBuffer  {

  private byte[] buffer;
  private int len;

  public ByteArrayBuffer(int capacity) {
      super();
      if (capacity < 0) {
       throw new IllegalArgumentException("Buffer capacity may not be negative");
      }