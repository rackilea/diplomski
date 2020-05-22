public static Boolean cmprStr( String s1, String s2 )
{
    for (int i = s1.length() - 1; i >= 0; --i) {
         if (s2.indexOf(s1.charAt(i)) == -1) {
             return Boolean.FALSE;
         }
    }
    return Boolean.TRUE;
}