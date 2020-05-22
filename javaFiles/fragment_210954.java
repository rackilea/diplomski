class A {
  void play1() {
    //...
  }
  void play2() {
    //....
  }
}
class B extends A {
  void play1() {
    //...
  }
}
B b = new B();
b.play1(); // 'first' call
b.play2(); // 'second' call