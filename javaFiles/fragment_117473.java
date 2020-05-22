public static String prefixOf(String s, char prefix) {
  for (int i = 0; i < s.length(); i++) {
    if (s.charAt(i) != prefix) {
      return s.substring(0, i);
    }
  }
  return s;
}