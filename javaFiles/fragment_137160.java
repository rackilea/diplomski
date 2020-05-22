public static double geometricSum(double n) {
    System.err.println("Calling with " + n);
    if(n == 0){
      return 1;
    }
    n = n * 2;
    return 1.0 / n + geometricSum((1/Math.pow(2, n)));
  }