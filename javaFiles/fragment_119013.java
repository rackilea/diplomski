static final Map<Long, String> ORDINAL_DAYS = new HashMap<>();
static
{
  ORDINAL_DAYS.put(1, "First");
  ORDINAL_DAYS.put(2, "Second");
  ... values for month days 1 .. 31
  ORDINAL_DAYS.put(31, "Thirty-first");
}


DateTimeFormatter formatter = new DateTimeFormatterBuilder()
    .appendText(ChronoField.YEAR)
    .appendLiteral(' ')
    .appendText(ChronoField.MONTH_OF_YEAR)
    .appendLiteral(' ')
    .appendText(ChronoField.DAY_OF_MONTH, ORDINAL_DAYS)
    .toFormatter();

String formattedDate = formatter.format(date);