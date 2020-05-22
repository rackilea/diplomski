import static java.math.BigDecimal.ONE;

public class Sum {

    private static final TWO = new BigDecimal("2");
    private static final FOUR = new BigDecimal("4");
    private static final FIVE = new BigDecimal("5");
    private static final SIX = new BigDecimal("6");

    private BigDecimal f;
    private BigDecimal ak;

    private MathContext mc;

    public Sum(BigDecimal f, BigDecimal ak, MathContext mc) {
        this.f = f;
        this.ak = ak;
        this.mc = mc;
    }

    public BigDecimal calculate() {

        return inverse(f).multiply(
            firstSubtractRest(
                xOverYPlusZ(FOUR, ak, ONE),
                xOverYPlusZ(TWO, ak, FOUR),
                xOverYPlusZ(ONE, ak, FIVE),
                xOverYPlusZ(ONE, ak, SIX),

            ));

    }

    private BigDecimal inverse(BigDecimal x) {
        return ONE.divide(x, mc);
    }

    /* returns x / (y + z) */
    private BigDecimal xOverYPlusZ(BigDecimal x, BigDecimal y, BigDecimal z) {
        BigDecimal divisor = y.add(z);
        return x.divide(divisor, mc);
    }

    private BigDecimal firstSubtractRest(BigDecimal... values) {
        BigDecimal value = values[0];
        for (int i = 1; i < values.length; i++) {
            value = value.subtract(values[i]);
        }
        return value;
    }

}