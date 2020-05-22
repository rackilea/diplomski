public class Foo {

  static String a;

  static {
    a = "foo";
  }

  static String b = a;

  static {
    System.println(b);
  }

}