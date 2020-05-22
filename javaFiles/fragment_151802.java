public static boolean isEquals(String a, String b) {
   if (a.length() == 0)
       return b.length() == 0;
   if (b.length() == 0)
       return false;
   return a.charAt(0) == b.charAt(0) &&
       isEquals(a.subString(1), b.subString(1));
}