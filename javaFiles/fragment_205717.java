class Foo {

  final Object finalVal;
  Object nonFinalVal;

  Bar(Object val) {
    finalVal = val;
    nonFinalVal = val;
  }
}