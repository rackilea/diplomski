class A {
   private final int a;
   public A() throws Exception { 
      a = 10;
   }
}

class B extends A {
   private final int b;
   public B() throws Exception {
       methodThatThrowsException(); 
       b = 20;
   }
}

class C extends B {
   public C() throws Exception { super(); }
}