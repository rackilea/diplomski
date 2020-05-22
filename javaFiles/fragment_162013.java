private static String star(int n) {
  if (n==0) {
    String b ="*";
    return b;
  } else {
    String t = star(n-1);
    return t + t;
  }
}