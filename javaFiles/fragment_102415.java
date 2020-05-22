/**
 * Parses the string argument as a signed decimal integer. The
 * characters in the string must all be decimal digits, except
 * that the first character may be an ASCII minus sign {@code '-'}
 * ({@code '\u005Cu002D'}) to indicate a negative value or an
 * ASCII plus sign {@code '+'} ({@code '\u005Cu002B'}) to
 * indicate a positive value. The resulting integer value is
 * returned, exactly as if the argument and the radix 10 were
 * given as arguments to the {@link #parseInt(java.lang.String,
 * int)} method.
 *
 * @param s    a {@code String} containing the {@code int}
 *             representation to be parsed
 * @return     the integer value represented by the argument in decimal.
 * @exception  NumberFormatException  if the string does not contain a
 *               parsable integer.
 */