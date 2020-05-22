class Test<A> {
  class Inner<A> {
    // here A denotes the generic parameter of Test.Inner
    // the type A of Test is hidden
  }
  <A> void test() {
    // here it is not a class but the type parameter A of Test is also hidden
    // if I remember well, the warning shows these too
  }
}