public class SuperClass{
     public method1(){
         method2(); // Note that you don't need any instance check here.
         //do some more stuff
     }

     public method2(){
         SOP("Super method2");
     }
}

public class SubClass extends SuperClass{
     @Override
     public method2(){ // Note that you don't have to override method1
         SOP("SUB method2")
     }
}