interface FooWithDefault {
    public default int Foo (int a) {
      return Foo(a, 1, 1);
    }

    public default int Foo (int a, int b) {
      return Foo(a, b, 1);
    }

    // Let implementations handle this
    public int Foo (int a, int b, int c);
}