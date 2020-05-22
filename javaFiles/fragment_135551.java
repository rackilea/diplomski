public static String[] clean(final String[] v) {
  int r, w, n = r = w = v.length;
  while (r > 0) {
    final String s = v[--r];
    if (!s.equals("null")) {
      v[--w] = s;
    }
  }
  final String[] c = new String[n -= w];
  System.arraycopy(v, w, c, 0, n);
  return c;
}