public class A {

      //Constructor
      public A(){
        B testB = new B();
        testB.setName("test");
      }

      //Method
      public void setup(){

        B testB = new B();
        testB.setName("test"); 
       }
    }

    /*Then in a main method or some other class create an instance of A 
and call the setup method.*/

    A a = new A();
    a.setup();