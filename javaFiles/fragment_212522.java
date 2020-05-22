public class Foo() {
    static { /* works fine! ! */
      System.setProperty("java.awt.headless", "true");
      System.out.println(java.awt.GraphicsEnvironment.isHeadless());
      /* ---> prints true */
    }

    private static final Color COLOR_BACKGROUND = Color.WHITE;

    public static void main() {}
  }