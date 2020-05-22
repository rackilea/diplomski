public class CustomBigDecimal extends BigDecimal {

    private final BigDecimal value;

    private CustomBigDecimal(BigDecimal value) {
        super(value.toPlainString()); // needed to compile, 
                                      // useless except for implicit null-check
        this.value = value;
    }

    public CustomBigDecimal(String val) {
        this(new BigDecimal(val).setScale(2, RoundingMode.HALF_UP));
    }

    @Override
    public CustomBigDecimal abs() {
        return new CustomBigDecimal(this.value.abs());
    }

    // TODO all other methods

}