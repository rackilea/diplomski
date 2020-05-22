public class Foo {
  public Foo() {
    this(makeBar());
  }
  public Foo(Bar b) {
    // ...
  }
  private static Bar makeBar() {
    Bar b = new Bar();
    b.setSomeData();
    b.doSomethingElse();
    return b;
  }
}