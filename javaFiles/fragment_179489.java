public static int hash(String s) {
  int hash = 0;
  for (int i = 0; i < s.length(); i++) {
      hash = 257*hash + s.charAt(i);
  }
  return h;
}