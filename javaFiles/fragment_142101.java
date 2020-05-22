class A {

  final Object data;

  A(final Object _data) {
    data = _data;
  }

  static class B extends A {

    B() {
      super(new C());
    }

    static class C {
    }
  }
}