public abstract class Calculate {

    public static final double EUR = 0.133;//drži vrednost

    public static BigDecimal croToEu(double hrkValue) {

        BigDecimal fixDecimal = new BigDecimal(hrkValue * EUR);
        fixDecimal = fixDecimal.setScale(2, BigDecimal.ROUND_HALF_UP);

        return fixDecimal;
    }

}