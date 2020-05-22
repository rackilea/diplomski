public class Foo {
  public Foo(Foo f) {}
  public static void main(String[] args) {
    new Foo(new Foo(new Foo(new Foo(null))));
  }
}