DateTimeFormatter formatter = new DateTimeFormatterBuilder()
            .appendValue(ChronoField.MONTH_OF_YEAR)
            .appendValue(ChronoField.DAY_OF_MONTH, 2)
            .appendValue(ChronoField.YEAR, 4)
            .toFormatter();

    System.out.println(LocalDate.parse("10011970", formatter));
    System.out.println(LocalDate.parse("1011970", formatter));