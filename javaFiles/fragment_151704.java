public class Bar {

  static void foo(boolean b) {
    foo: {
      if (b) {
        break foo;
      }
      System.out.println(b);
    }
  }

  public static void main(String[] args) {
    foo(true);
    foo(false);
  }
}