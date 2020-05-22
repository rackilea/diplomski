class A {
   private B myB;

   public void doSomething() { ... }

   public void createB() {
     myB = new B(this);
   }
}

class B {
   private A daddy;
   public B(A myDaddy) { this.daddy = myDaddy };

   public void doSomethingWithA() { daddy.doSomething(); }
}