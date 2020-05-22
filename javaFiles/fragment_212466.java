static double min(double... ds) {
  double min = Double.POSITIVE_INFINITY;
  for (double d : ds) min = Math.min(min, d);
  return min;
}

public static void main(String[] args) {
  System.out.println(min(-5.2, 0, -10.1, 3));
}