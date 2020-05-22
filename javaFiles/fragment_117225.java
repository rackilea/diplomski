public final class B extends A {
  public <R> R fold(R b, R c, R d) {
    return b;
  }
}

public final class C extends A {
  public <R> R fold(R b, R c, R d) {
    return c;
  }
}

public final class D extends A {
  public <R> R fold(R b, R c, R d) {
    return d;
  }
}