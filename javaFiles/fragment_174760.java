class A {
  static class B { private String f; }

  abstract static class Builder<T extends B> {
    abstract T getB();

    {
      ((B)getB()).f.hashCode();
      getB().f.hashCode(); // error: f has private access in A.B
    }

  }
}