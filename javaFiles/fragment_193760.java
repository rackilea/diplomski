public class learningJava
{
    public static String last4()
    {
       String str = "something";
       //int length = str.length();
       String substr = str.substring(str.length() - 4);
       if (str.length() < 4)
       {
           return str;
       }
      return str.substring(str.length() - 4);
    }  

}