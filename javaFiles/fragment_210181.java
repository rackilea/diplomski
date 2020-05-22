package your.package;

public class Activity {
  static {
    System.loadLibrary("your_library");
  }

  public native void test();
}