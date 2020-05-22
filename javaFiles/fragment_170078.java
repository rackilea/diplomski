public boolean xyzMiddle(String str) {
  if (str.indexOf("xyz") < 0) return false;
  int l = str.length();
  int m = l / 2;
  if (l % 2 != 0) {
   if (!(str.substring((m - 1), m + 2).equals("xyz"))) 
   return false;
  }
  else {
   if (str.charAt(m) != 'y' && str.charAt(m - 1) != 'y') return false;
  }
  return true; 
}