public static int findInStr1(String s1, String s2) {
  for (int i = s1.length() - 1; i >= s2.length() - 1; i--) {
    boolean found = true;
    for (int j = s2.length() - 1; j >= 0; j--) {
       if (s1.charAt(i-(s2.length()-1-j)) != s2.charAt(j)) {
          found = false;
          break;
       }
    }
    if (found) {
        return i-s2.length()+1;
    }
  }
  return -1;  
}