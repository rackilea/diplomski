class A {
  private int a;
  public A(int a) { this.a = a; }
  public int getA() {return a;}
}

class B extends A {
  public B(int b) { super(b); }
  public int getB() {return getA();}
}

int result = new B(10).getA();