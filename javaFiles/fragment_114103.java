public static void main(String[] args)
  {
    // start with large number
    int m = Integer.MAX_VALUE;
    double d = 0;

    double largestError = 0;
    int bigErrorCause = -1;
    for (int n = 1; n < Integer.MAX_VALUE; n++)
    {
      d = (double) m / n;
      double possibleError = Math.ulp(d) * n;
      if (possibleError > largestError)
      {
        largestError = possibleError;
        bigErrorCause = n;
      }
    }
    System.out.println("int " + bigErrorCause + " causes at most "
        + largestError + " error");
  }