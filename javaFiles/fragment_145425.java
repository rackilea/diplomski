class A {
  void method() {
    String s = "test";
    B b = new B(s);
    b.setValue(s);
  }
}

class B {
  private String value;

  B(String val) {
    value = val;
  }

  public void setValue(String val) {
    value = val;
  }
}