struct A {
  A(const std::set& s); // this cannot be used directly unfortunately
}

%extend A {
  A(const SetWrapper& s) { // need a constructor with SetWrapper
    A *p = new A(s.data); // reuse the constructor above
    return p;
  }
}