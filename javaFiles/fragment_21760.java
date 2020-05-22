class A
{
  B b = new B(this);
}

class B
{
  B(A a) { this.foo = a.foo; ... }  // Constructor
  C c = new C(this);
}

class C
{
  C(B b) { this.foo = b.foo; ... }  // Constructor
  D d = new D(this);
}

class D
{
  D(C c) { this.foo = c.foo; ... }  // Constructor
}