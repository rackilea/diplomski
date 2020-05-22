class A {
  public String whatever = "bla";
}

class B {
  void foo() {
    String other = new A().whatever;
}