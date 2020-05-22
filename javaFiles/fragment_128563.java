class TestMyClass extends MyClass {

  @Override // fortunately, the original method called in constructor can be overridden (what could be considered bad)
  public MyObject getMyObject() {
    // something that does not fail the constructor
  }

}