public class Foo {
  // Private constructor forces instances to be created using factory method.
  private Foo() {}

  protected void onCreate() {}

  static Foo newInstance() {
    Foo foo = new Foo();
    new Thread(foo::onCreate).start();
    return foo;
  }
}