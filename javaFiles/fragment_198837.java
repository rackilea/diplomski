public static boolean hasBAB(String str) {
  if (str.length() < 3) return false;
  if (str.substring(0,3).equals("bab"))
    return true;
  else
    return hasBAB(str.substring(1));
}