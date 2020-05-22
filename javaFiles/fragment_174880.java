abstract class C {
  public final int x;

  C() {
    this.x = f();
  }

  abstract int f();
}