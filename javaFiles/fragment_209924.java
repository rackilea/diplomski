class A {
   public int a;
   public int b;
   public String c;

   public A() {

   }

   protected void someMethod() {

   }
}

class B extends A {
  // a, b, c from the parent A class are accessible here

  public int d;
  public String e;

  public B() {
    super();
  }

  // someMethod() is accessible here
}