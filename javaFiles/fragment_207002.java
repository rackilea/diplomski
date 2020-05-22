public class Matrix2x2 {
  double a11,a12,a21,a22;
}

public static void mult( Matrix2x2 a , Matrix2x2 b , Matrix2x2 c ) {
  c.a11 = a.a11*b.a11 + a.12*b.a21;
  c.a12 = a.a11*b.a12 + a.12*b.a22;
  c.a21 = a.a21*b.a11 + a.22*b.a21;
  c.a22 = a.a21*b.a12 + a.22*b.a22;
}