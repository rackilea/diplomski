public class Foo {
  public static void something() { ... }
}

public class Arguments<T extends Foo> {
  private Class<? extends Foo> foo;
  public Arguments(Class<? extends Foo> foo) {
    this.foo = foo;
  }
  public List<T> execute() {
    foo.something();

  }
}