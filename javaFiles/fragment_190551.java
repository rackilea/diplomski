final String dateString = "Jan 2, 2012";
final DateTimeFormatter dtf = new DateTimeFormatterBuilder().appendMonthOfYearShortText().appendLiteral(" ").appendDayOfMonth(1).appendLiteral(", ").appendYear(4, 4).toFormatter();
final DateTime jodaDate = dtf.parseDateTime(dateString);
System.out.println(jodaDate);
final Date javaDate = new Date(jodaDate.getMillis());
System.out.println(javaDate);