public static boolean compareLast4 (String s1, String s2) 
{
    if (s1.length() < 4 || s2.length() < 4)
        return false;
    return s1.substring(s1.length() - 4).equals(s2.substring(s2.length()-4));
}