@Test
public void test() throws JsonProcessingException {
    final String value1 = "Nov 24 2014  2:40PM"; // Double space
    final String value2 = "Nov 24 2014 11:40PM"; // Single space

    // Set up a test time zone
    final ZoneId clientTimeZone = ZoneId.systemDefault();

    // Create the formatter (as previously)
    DateTimeFormatter df = DateTimeFormat.forPattern("MMM dd yyyy hh:mma");


    DateTime temp1 = 
        df.withZone(DateTimeZone.forTimeZone(TimeZone.getTimeZone(clientTimeZone)))
               .withOffsetParsed()
               .parseDateTime(value1.replace("  ", " ")); // replace double space with single space

    DateTime temp2 = 
        df.withZone(DateTimeZone.forTimeZone(TimeZone.getTimeZone(clientTimeZone)))
                .withOffsetParsed()
                .parseDateTime(value2.replace("  ", " ")); // always replace to be sre

    DateTime date1 = temp1.toDateTime(DateTimeZone.forTimeZone(TimeZone.getTimeZone("America/New_York")));
    DateTime date2 = temp2.toDateTime(DateTimeZone.forTimeZone(TimeZone.getTimeZone("America/New_York")));
    Timestamp ts1 = new Timestamp(date1.getMillis());
    Timestamp ts2 = new Timestamp(date2.getMillis());
}