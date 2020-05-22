/**
 * The number of decimal digits in this BigDecimal, or 0 if the
 * number of digits are not known (lookaside information).  If
 * nonzero, the value is guaranteed correct.  Use the precision()
 * method to obtain and set the value if it might be 0.  This
 * field is mutable until set nonzero.
 *
 * @since  1.5
 */
private transient int precision;