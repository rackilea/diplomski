class A {
   void foo() {
      synchronized((Integer)42) {
         ...
      }
   }
}

class B {
   void foo() {
      synchronized((Integer)42) { 
          ...
      }
   }
}