final B b = new BImpl();
final B decoratedB = new B() {
  public void someMethod () {
    a.someMethodOfBisCalled();
    b.someMethod();
  }
};