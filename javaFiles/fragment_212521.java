public class Foo() {
    private static final Color COLOR_BACKGROUND = Color.WHITE;

    static { /* too late ! */
      System.setProperty("java.awt.headless", "true");
      System.out.println(java.awt.GraphicsEnvironment.isHeadless());
      /* ---> prints false */
    }

    public static void main() {}
  }