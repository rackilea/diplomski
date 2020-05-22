class B extends A {
        public void someOtherMethod(){
            super.print();
         }
    }
   from main:
      B  b = new B();
      b.someOthermethod();