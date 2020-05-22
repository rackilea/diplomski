public static double getValue(Scanner s, String msg) {
  double value = -1;
  while (value == -1) {
    System.out.print(msg);
    value = s.nextDouble();
  }
  return value;
}