public static double[] multi(double[] x, double[] y) {
     if (x.length != y.length) {
          System.out.println("Arrays must be same size");
          return null;
      }
      double[] result = new double[x.length];
      for (int i = 0; i < x.length; i++) {
        result[i] = x[i] * y[i];
      }
      return result;
  }