/* use this in place of an array */
final NavigableSet<BigDecimal> values = new TreeSet<BigDecimal>();
/* read from the user e.g. Scanner.nextBigDecimal() */
final BigDecimal ceiling = ...;
for (final BigDecimal lower : values.headSet(ceiling)) {
  /* lower will be less than ceiling */
}