public class Test {
  /**
   * Optimised for huge numbers.
   *
   * http://en.wikipedia.org/wiki/Logarithm#Change_of_base
   *
   * States that log[b](x) = log[k](x)/log[k](b)
   *
   * We can get log[2](x) as the bitCount of the number so what we need is
   * essentially bitCount/log[2](10). Sadly that will lead to inaccuracies so
   * here I will attempt an iterative process that should achieve accuracy.
   *
   * log[2](10) = 3.32192809488736234787 so if I divide by 10^(bitCount/4) we
   * should not go too far. In fact repeating that process while adding (bitCount/4)
   * to the running count of the digits will end up with an accurate figure
   * given some twiddling at the end.
   * 
   * So here's the scheme:
   * 
   * While there are more than 4 bits in the number
   *   Divide by 10^(bits/4)
   *   Increase digit count by (bits/4)
   * 
   * Fiddle around to accommodate the remaining digit - if there is one.
   * 
   * Essentially - each time around the loop we remove a number of decimal 
   * digits (by dividing by 10^n) keeping a count of how many we've removed.
   * 
   * The number of digits we remove is estimated from the number of bits in the 
   * number (i.e. log[2](x) / 4). The perfect figure for the reduction would be
   * log[2](x) / 3.3219... so dividing by 4 is a good under-estimate. We 
   * don't go too far but it does mean we have to repeat it just a few times.
   */
  private int log10(BigInteger huge) {
    int digits = 0;
    int bits = huge.bitLength();
    // Serious reductions.
    while (bits > 4) {
      // 4 > log[2](10) so we should not reduce it too far.
      int reduce = bits / 4;
      // Divide by 10^reduce
      huge = huge.divide(BigInteger.TEN.pow(reduce));
      // Removed that many decimal digits.
      digits += reduce;
      // Recalculate bitLength
      bits = huge.bitLength();
    }
    // Now 4 bits or less - add 1 if necessary.
    if ( huge.intValue() > 9 ) {
      digits += 1;
    }
    return digits;
  }

  // Random tests.
  Random rnd = new Random();
  // Limit the bit length.
  int maxBits = BigInteger.TEN.pow(200000).bitLength();

  public void test() {
    // 100 tests.
    for (int i = 1; i <= 100; i++) {
      BigInteger huge = new BigInteger((int)(Math.random() * maxBits), rnd);
      // Note start time.
      long start = System.currentTimeMillis();
      // Do my method.
      int myLength = log10(huge);
      // Record my result.
      System.out.println("Digits: " + myLength+ " Took: " + (System.currentTimeMillis() - start));
      // Check the result.
      int trueLength = huge.toString().length() - 1;
      if (trueLength != myLength) {
        System.out.println("WRONG!! " + (myLength - trueLength));
      }
    }
  }

  public static void main(String args[]) {
    new Test().test();
  }

}