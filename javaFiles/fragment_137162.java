public static double geometricSum(int count) {
    if (count == 0) {
      return 1;
    }
    return geometricSum(count-1) + Math.pow(2, -count);
}