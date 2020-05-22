Locale locale = new Locale("en", "US");
    DateTimeFormatter formatter =
            new DateTimeFormatterBuilder()
                    .appendPattern("yyyyMMddHHmmss")
                    .appendValue(ChronoField.MILLI_OF_SECOND, 3)
                    .toFormatter();
    LocalTime time = LocalTime.parse("20190502050634678",formatter);