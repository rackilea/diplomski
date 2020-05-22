class ComplexLogician {

  String myMethod(String a, String b) {
    /* Complex logic here. */
  }

}

class MyClass {

  private String s;

  private final ComplexLogician logic;

  /* More attributes here... */

  MyClass(String s, ComplexLogician logic, /* More parameters... */)  {...}

  String myMethod(String b) {
    return logic.myMethod(s, b);
  }

}