public static String depad(String s)
{
    while(s.charAt(0) == (char)0)
    {
        s = s.substring(1);
    }
}