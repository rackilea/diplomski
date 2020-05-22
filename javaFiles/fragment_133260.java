public class checknull
{
    // static boolean ch; (You don't need this static variable)
    public static boolean value(String check)
    {
       return check != null && check.length() > 0;
    }
}