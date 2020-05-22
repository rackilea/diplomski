@Override
public final StringBuffer format(Object number,
                                 StringBuffer toAppendTo,
                                 FieldPosition pos) {
    if (number instanceof Long || 
        number instanceof Integer ||                   
        number instanceof Short || 
        number instanceof Byte ||                   
        number instanceof AtomicInteger ||
        number instanceof AtomicLong ||
        (number instanceof BigInteger && ((BigInteger)number).bitLength () < 64)) {

        return format(((Number)number).longValue(), toAppendTo, pos);
    } else if (number instanceof BigDecimal) {
        return format((BigDecimal)number, toAppendTo, pos);
    } else if (number instanceof BigInteger) {
        return format((BigInteger)number, toAppendTo, pos);
    } else if (number instanceof Number) {
        return format(((Number)number).doubleValue(), toAppendTo, pos);
    } else {
        throw new IllegalArgumentException("Cannot format given Object as a Number");
    }
}