class Example {
  final class Inner {
    final boolean b;
    final String s;

    Inner(boolean b, String s) {
      this.b = b; this.s = s;
    }

    void foo() {
      // This can use the values of b and s passed to run().
    }
  }

  public abstract void example(Inner inner);

  public void run(boolean b, String s) {
    example(new Inner(b, s));
  }
}