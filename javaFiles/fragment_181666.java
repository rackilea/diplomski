interface AbstractA {
   void foo(Object o);
}
class A implements AbstractA {
  @Override
  public void foo(Object o) {}
}

class B implements AbstractA {
  private AbstractA abstractA;

  @Override
  public void foo(Object o) {
    abstractA.foo(o);
    // "a slightly different result"
  }
}