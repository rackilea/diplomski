public class Outer{


     class Inner{


     }

 }


public class Test{


   public static void main(String[] args){

         Outer o = new Outer();
         Outer.Inner i = o.new Inner();

    }
}