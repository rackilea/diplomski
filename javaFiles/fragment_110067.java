DateTimeFormatter df = new DateTimeFormatterBuilder()
    .appendValue(YEAR, 4)
    .appendPattern("MMdd'0000'")
    .toFormatter()
    .withChronology(IsoChronology.INSTANCE)
    .withResolverStyle(ResolverStyle.STRICT);

log.info(LocalDate.parse("201909260000", df).toString());  // 2019-09-26
log.info(df.format(LocalDate.of(2019, 9, 26)));            // 201909260000