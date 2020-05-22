public class learningJava
{
    public static String last4(String y)
    {

       //int length = y.length();
       String substr = y.substring(y.length() - 4);
       if (y.length() < 4)
       {
           return y;
       }
      return y.substring(y.length() - 4);
    }  

}