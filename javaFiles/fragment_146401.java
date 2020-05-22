double x[] = { 1, 2, 3 };
  double y[] = { 4, 5, 6 };

  double [] result = multi(x, y);


  public static double[] multi(double[] x, double[] y) {
     if (x.length != y.length) {
          System.out.println("Arrays must be same size");
          return null;
      }
      for (int i = 0; i < x.length; i++) {
        x[i] *= y[i];
      }
      return x;
  }