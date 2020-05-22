final String time = "Thu Aug 29 17:46:11 GMT+05:30 2019";
    final String format = "EEE MMM dd HH:mm:ss 'GMT'ZZ YYYY";

    DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(format)
            .withLocale(Locale.ENGLISH)
            .withOffsetParsed();
    DateTime dateTime = DateTime.parse(time, dateTimeFormatter);
    System.out.println(dateTime);