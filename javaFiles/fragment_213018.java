public static double m(int i) {
  if (i == 1) {
    // Base case is 1 - return the first number in the series
    return 1/3;
  } else {
    // Get the current step (ie the current iteration of m(i))
    double curStep = i / (2.0 * i + 1.0);

    // Return the current step plus the next step down
    return curStep + m(i - 1);
  }
}