public class Test {
  public static void main(String... args) {
    StringBuffer a = new StringBuffer("Foo!");
    StringBuffer b = a;
    a = null;
    System.out.println(b);
    // Foo!
  }
}