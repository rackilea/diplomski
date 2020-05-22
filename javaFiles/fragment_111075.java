public class Data
{
  private static Data myData = null;

  private Data() // Private constructor for singletons
  {
     // ...
  }

  public static Data getInstance()
  {
     if(myData == null)
         myData = new Data();

     return myData;
  }
}