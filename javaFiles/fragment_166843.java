DateTimeFormatter birthdateFormat = new DateTimeFormatterBuilder()
            .appendValue(ChronoField.YEAR, 4, 4, SignStyle.NEVER)
            .appendValue(ChronoField.MONTH_OF_YEAR, 2, 2, SignStyle.NEVER)
            .appendValue(ChronoField.DAY_OF_MONTH, 2, 2, SignStyle.NEVER)
            .appendLiteral("000000+0000")
            .toFormatter();

    // Outputs 20181227000000+0000
    String formatted = date.format(birthdateFormat);
    System.out.println(formatted);

    // Parses into 2018-12-27
    date = LocalDate.parse("20181227000000+0000", birthdateFormat);
    System.out.println(date);