public class Foo {
  protected final int x;
  Foo() {
    foo();
    this.x = 1;
    foo();
  }
  void foo() { System.out.println(this.x); }
  public static void main(String[] argv) { new Foo(); }
}