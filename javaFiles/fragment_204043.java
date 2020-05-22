class A {
  static final int X = B.Y;
  // Call to Math.min defeats constant inlining
  static final int Y = Math.min(42, 43);
}

class B {
  static final int X = A.Y;
  static final int Y = Math.min(42, 43);
}

public class C {
  public static void main(String[] argv) {
    System.err.println("A.X=" + A.X + ", A.Y=" + A.Y);
    System.err.println("B.X=" + B.X + ", B.Y=" + B.Y);
  }
}