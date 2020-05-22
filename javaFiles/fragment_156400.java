static class D extends C {
    void func(A a){ 
        a.f(); 
    }
}

  B b = new B();
  C c = new D();
  c.func(b);