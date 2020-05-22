class B {
  public static final String FOO = "foo";
}

class A {
  A() { System.out.println(B.FOO); }
}