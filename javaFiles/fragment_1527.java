class A {
    class B {
        public void doSomething() {
         // this here refers to an instance of the class B
         System.out.println(this);
         // We need to write is this way,
         // because this hides the this reference to the instance of A.
         // A.this is the instance of A where this is nested
         System.out.println(A.this); 
     }
}