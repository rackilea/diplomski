public class foo {
  static {
    // load libfoo.so / foo.dll
    System.loadLibrary("foo");
  }

  private native void nativecall();

  public static void main(String[] args) {
    foo f = new foo();

    f.nativecall();
  }

  public void callback() {
    System.out.println("callback");
  }

  public static void callback_static() {
    System.out.println("static callback");
  }
}