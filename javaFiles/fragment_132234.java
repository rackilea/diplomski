static int count() {
  byte [] count = new byte[MAX + 1];
  int result = 0;
  for (int m = 2; m < SQRT_MAX; ++m) {
    for (int n = 1; n < m; ++n) {
      if (((m ^ n) & 1) == 0 || gcd(m, n) > 1) continue;
      int base_len = 2 * m * (n + m);
      if (base_len > MAX) break;
      for (int len = base_len ; len <= MAX; len += base_len) { 
        switch (count[len]) {
        case 0:
          ++result;
          count[len] = 1;
          break;
        case 1:
          --result;
          count[len] = 2;
          break;
        default:
          break;
        }
      }
    }
  }
  return result;
}