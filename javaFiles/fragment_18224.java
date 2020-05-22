public interface Behaviour
{
   void function()
}

// in java
public class ABehaviour implements Behaviour
{
   public void function()
   {
      // TypeA behaviour
   }
}

public class BBehaviour implements Behaviour
{
   public void function()
   {
      // TypeB behaviour
   }
}

// In Java
Behaviour someBehaviour= new ABehaviour();
someBehaviour.function();
someBehaviour = new BBehaviour ();
someBehaviour.function();