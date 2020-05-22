class ZeroAwareDecimalFormat extends DecimalFormat {
    private final DecimalFormat zeroFormat;

    public ZeroAwareDecimalFormat(String posNegPattern, String zeroPattern) {
        super(posNegPattern);
        zeroFormat = new DecimalFormat(zeroPattern);
    }

    @Override
    public StringBuffer format(long number, StringBuffer result, FieldPosition fieldPosition) {
        if (number == 0L) {
            return zeroFormat.format(number, result, fieldPosition);
        } else {
            return super.format(number, result, fieldPosition);
        }
    }

    // Override the other methods accordingly.
    // set... methods should be propagated to super and zeroFormat.
}