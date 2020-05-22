public class Bezier {

  public static class v {

    public double x;
    public double y;

    public v(double x, double y) {
      this.x = x;
      this.y = y;
    }
  }

  public static double length(v p0, v p1, v p2) {
    v a = new v(p0.x - (2 * p1.x) + p2.x, p0.y - (2 * p1.y) + p2.y);
    v b = new v((2 * p1.x) - (2 * p0.x), (2 * p1.y) - (2 * p0.y));
    double A = 4 * (a.x * a.x + a.y * a.y);
    double B = 4 * (a.x * b.x + a.y * b.y);
    double C = b.x * b.x + b.y * b.y;
    double Sabc = 2 * Math.sqrt(A + B + C);
    double A_2 = Math.sqrt(A);
    double A_32 = 2 * A * A_2;
    double C_2 = 2 * Math.sqrt(C);
    double BA = B / A_2;
    return (A_32 * Sabc + A_2 * B * (Sabc - C_2) + (4 * C * A - B * B) * Math.log((2 * A_2 + BA + Sabc) / (BA + C_2))) / (4 * A_32);
  }
}