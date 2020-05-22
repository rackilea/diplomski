public static int sum(int n, int start) {
  if (start > n) {
    return 0;
  }

  if (start == n){
      return n;
  }

  int n2 = (start + n) / 2;
  return sum(n2, start) + sum(n, n2 + 1);
}