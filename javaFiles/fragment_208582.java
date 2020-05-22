double calculateY(double x) {
  double value = 4*(x*x) + 5*x - 3;
  return value;
}

public static void main(String[] args) {
  double x = 0;
  double y = 0;

  while (x <= 1.0) {
    x += 0.1;
    y = calculateY(x);
    System.out.print(y);
  }
}