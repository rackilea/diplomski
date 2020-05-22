public abstract class MyTypeObject extends Object
{
   abstract int getType();
}

public class MyObject1 extends MyTypeObject
{
   private int type = 201; 

   int getType()
   {
       return type;
   }   
}