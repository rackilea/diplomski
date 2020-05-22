public class C {

    A a = new A();
    B b = new B();

   private void methodCaller(){

      a.getMethodFromClassA();
      b.getMethodFromClassB();
   }
}