String dateString = "2019-06-01 00:15:00";
    dateString = dateString.replace(" ", "T");
    dateString = dateString.concat("Z");

    DateTimeFormatter formatter = DateTimeFormatter
            .ofLocalizedDateTime(FormatStyle.SHORT, FormatStyle.MEDIUM)
            .withLocale(Locale.FRENCH);
    OffsetDateTime dateTime = OffsetDateTime.parse("2019-06-01T00:15:00Z");
    String formattedDateTime = dateTime.format(formatter);

    System.out.println("Formatted date/time: " + formattedDateTime);