public static final double ROUND_MULTIPLIER = 100000.0;

public void foobar()
{
    double a = 1.07522;
    double b = 1.0752;

    BigDecimal opA = BigDecimal.valueOf(a);
    BigDecimal opB = BigDecimal.valueOf(b);

    BigDecimal result = opA.subtract(opB);

    result = result.multiply(BigDecimal.valueOf(ROUND_MULTIPLIER));

    int cutResult = result.intValue();

    result = BigDecimal.valueOf(cutResult / ROUND_MULTIPLIER);

    System.out.println(result);
}