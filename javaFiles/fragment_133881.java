interface AbsClass {

  default void algorithm(){
    step1();
    step2();
  }

  default void step1() {
    // implementation or empty
  }

  default void step2() {
    // empty body in default case
  }
}

class B implements AbsClass { }