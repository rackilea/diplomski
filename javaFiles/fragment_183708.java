public class SubClass implements MyInterface {
   private MyInterfaceBasicImpl base;

   int fooB(){
      int temp = base.fooB();
      temp += 1;
      return temp;
   }

   int fooC(){
      System.out.println("I'm doing something using in fooC in base object!");
      return base.fooC();
   }
}