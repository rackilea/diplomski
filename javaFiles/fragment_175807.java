public class A {
  private static class BImpl implements B {
    @Override public void method() {
    }
  }

  private final B b = new BImpl();

  public B getB() { return b; }
}