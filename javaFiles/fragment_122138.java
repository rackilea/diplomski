class Bar<S> {
  /* non-static */ class Foo<U extends Foo<U>> {}
}

Bar.Foo<?> foo = null; // error
Bar<String>.Foo<?> foo = null; // fine