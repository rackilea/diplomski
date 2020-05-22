public class Testing
{    
   public static void main(String args[])
   {
      subclass sub = new subclass();
      superclass sup = (superclass) sub; 
      subclass theSub = (subclass) sup;
      theSub.displaySub();
   }
}