public class FooFactory {

  private static Set<int> ids = new Set<int>();

  public static Foo createFoo(int value) {
    if (ids.contains(value)) {
      throw new FooAlreadyExistsException();
    }

    ids.add(value);
    return new Foo(value);
  }
}