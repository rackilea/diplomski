DateTimeFormatter fmt = new DateTimeFormatterBuilder()
    .append(DateTimeFormatter.ISO_OFFSET_DATE)
    .parseDefaulting(ChronoField.HOUR_OF_DAY, 0)
    .toFormatter();
OffsetDateTime dt = OffsetDateTime.parse("2015-01-15-05:00", fmt);
LocalDate date = dt.withOffsetSameInstant(ZoneOffset.UTC).toLocalDate();