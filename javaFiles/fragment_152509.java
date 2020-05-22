private static final void f(Object a) {
  Intrinsics.reifiedOperationMarker(4, "T"); // I didn't see
  // the implementation of this line, so I thought it's
  // possible to call it in other languages
  Class var2 = Object.class;
  System.out.println(var2);
}