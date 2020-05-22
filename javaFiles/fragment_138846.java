public static void main(String[] args) {
  DecimalFormat df = new DecimalFormat("0.##E0");
  int n = 10;
  int x = 3;
  int scale = 500;

  BigInteger fact = BigInteger.ONE;
  int rangeEndPrev = 0;
  int sign = 1;
  for (int i = 1; i <= n; i++)
  {
    int rangeEnd = i*i + 1;
    for (int j = rangeEndPrev + 1; j <= rangeEnd; j++)
      fact = fact.multiply(BigInteger.valueOf(j));
    BigDecimal a1 = BigDecimal.valueOf((sign * Math.log(i * x)) / i);
    BigDecimal a  = a1.divide(new BigDecimal(fact), scale, BigDecimal.ROUND_HALF_EVEN);
    System.out.println(df.format(a));
    rangeEndPrev = rangeEnd;
    sign = -sign;
  }
}