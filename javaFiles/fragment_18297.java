String text = "20170925142051591";
DateTimeFormatter formatter = new DateTimeFormatterBuilder()
    // date/time
    .appendPattern("yyyyMMddHHmmss")
    // milliseconds
    .appendValue(ChronoField.MILLI_OF_SECOND, 3)
    // create formatter
    .toFormatter();
// now it works
formatter.parse(text);