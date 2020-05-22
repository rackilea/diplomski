class MyClass {

  private boolean b1;
  private boolean b2;

  public MyClass(boolean b1, boolean b2) {
    this.b1 = b1;
    this.b2 = b2;
  }

  int myMethod() {
    return getSize();
  }

  int getSize() {
    return 42;
  }

  public boolean getB1() {
    return b1;
  }

  public boolean getB2() {
    return b2;
  }
}