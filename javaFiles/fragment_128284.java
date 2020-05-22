public int test1(int n) {
  int y = 2*n;
  return y + test2(n+1);
}

public int test2(int n) {
  int y = 3*n;
  return y - n/3;
}