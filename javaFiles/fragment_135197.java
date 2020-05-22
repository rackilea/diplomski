class Point {
  private double x;
  private double y;

  // Computes norm2 of the point
  public double norm2() {
    return Math.sqrt(x*x + y*y);
  }
}