int h(String s) {
  int res = 0;
  int n = ht.length;

  for (int i = s.length() - 1; i >= 0; i--) {
     // using a long here to prevent premature wrapping
     long t = res * 256L + s.charAt(i);
     res = (int)(t % n);
  }
  return (res + 1) % n;
}