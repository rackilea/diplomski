public static double stdDev(double[] inputArray) {
    double sum = 0;
    double sq_sum = 0;
    for (int i = 0; i < inputArray.length; ++i) {
      double ai = inputArray[i];
      sum += ai;
      sq_sum += ai * ai;
    }
    double mean = sum / inputArray.length;
    double variance = sq_sum / inputArray.length - mean * mean;
    return Math.sqrt(variance);
  }