class A {
  public static final String FOO = "foo";

  static { System.out.println("loaded A"); }
}

public class B {
  public static void main(String... argv) {
    System.out.println("Got " + A.FOO);
  }
}