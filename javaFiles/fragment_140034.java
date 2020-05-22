public DecimalValue(double in) throws ValidationException {
        try {
            BigDecimal d = new BigDecimal(in);
            value = d.stripTrailingZeros();
        } catch (NumberFormatException err) {
            //...
        }