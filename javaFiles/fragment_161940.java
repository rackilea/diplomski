public class Outer {
  public static class Nested {
    public void foo() { System.out.println("Foo"); }
  }
}

new Outer.Nested.foo();