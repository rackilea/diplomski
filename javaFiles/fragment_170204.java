public class A {
  B b = new B(this);
  C c = new C(this);
}

public class B {
  public B(A a) {

  }
}

public class C {
  public C(A a) {

  }
}