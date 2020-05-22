public class Derived extends Base {

   @Override
   public Int getInt() { 
        returnsOne(); 
   }

   private Int returnsOne() { return 1; }
}