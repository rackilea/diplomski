public class X
{
   public X()
   {
      Y.CreateException();
      //or
      Y.CreateException("Error");
   }
}

public class Y
{
    public static void createException()
    {
         throw new RuntimeException();
    }

    public static void createException(String msg)
    {
         throw new RuntimeException(msg);
    }
}