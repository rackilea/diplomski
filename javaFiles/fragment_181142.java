A a = new A();
  B b = new B();
  AB ab = new AB();
  ab.setA(a);
  ab.setB(b);
  a.setAB(ab);
  b.setAB(ab);

  save(a);