LocalDateTime dt = LocalDateTime.now();
ZonedDateTime zdt = dt.atZone(ZoneId.systemDefault());
long numberOfMonths = 5L;
if (attr.creationTime().toInstant().isBefore(
        dt.minus(numberOfMonths, ChronoUnit.MONTHS).toInstant(zdt.getOffset())
    )
) {
    // do something
}