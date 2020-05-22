public static String docat2(String first, String second) {
  char[] f = first.toCharArray();
  char[] s = second.toCharArray();
  if (!first.contains("" + s[0]))
    return first + second;
  int idx = 0;
  try {
    while (!matches(f, s, idx)) idx++;
  } catch (Exception e) { }
  return first.substring(0, idx) + second;
}

private static boolean matches(char[] f, char[] s, int idx) {
  for (int i = idx; i <= f.length; i++) {
    if (f[i] != s[i - idx])
      return false;
  }
  return true;
}