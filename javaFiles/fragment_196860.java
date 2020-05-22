public class run {
  public static void main(String[] argv) {
    System.loadLibrary("test");
    byte value[] = "hello world\n".getBytes();
    java.nio.ByteBuffer buf = java.nio.ByteBuffer.wrap(value);
    test.foo(buf);
  }
}