public class Foo {

  private static Set<int> ids = new Set<int>();

  public Foo(int value) {
    if (ids.contains(value)) {
      throw new FooAlreadyExistsException();
    }

    ids.add(value);
  }
}