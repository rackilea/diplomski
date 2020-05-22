private static int count0(int n) {
  if (n <= 0)
    return 0;
  else 
    return  (n % 10 == 0 ? 1 :0) + count0(n / 10);
}