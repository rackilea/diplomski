public static String[] clean(final String[] v) {
  int r, w;
  final int n = r = w = v.length;
  while (r > 0) {
    final String s = v[--r];
    if (!s.equals("null")) {
      v[--w] = s;
    }
  }
  return Arrays.copyOfRange(v, w, n);
}