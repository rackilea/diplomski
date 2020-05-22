class Super {
  public Super() {
    doInit();
  }

  protected void doInit() { /* ... */ }
}

class A extends Super {
  // f and getF as before
}

class B extends A {
  protected void doInit() {
    System.out.println(getF());
  }
}