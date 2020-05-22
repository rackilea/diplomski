public static boolean isEquals(String a, String b) {
   if (a.length() != b.length()) return false;
   return isEquals(a, b, 0);
}

private static boolean isEquals(String a, String b, int index) {
    if (index >= a.length()) return true;
    if (a.charAt(index) != b.charAt(index)) return false;
    return isEquals(a, b, index + 1);
}