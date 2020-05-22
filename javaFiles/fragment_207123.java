interface A_j {
  <X> B_j<X> createB(X x);
}

interface B_j<X> {
  String superImportantMethod();
}