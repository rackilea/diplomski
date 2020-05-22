LocalDate date = LocalDate.of(2018, Month.DECEMBER, 27);
    String pattern = "yyyyMMddHHmmssxx";
    DateTimeFormatter birthdateFormat = DateTimeFormatter.ofPattern(pattern);

    // Outputs 20181227000000+0000
    String formatted = date.atStartOfDay(ZoneOffset.UTC).format(birthdateFormat);
    System.out.println(formatted);

    // Parses to 2018-12-27T00:00Z
    OffsetDateTime odt = OffsetDateTime.parse("20181227000000+0000", birthdateFormat);
    System.out.println(odt);
    // Validate
    if (! odt.toLocalTime().equals(LocalTime.MIN)) {
        System.out.println("Unexpected time of day: " + odt);
    }
    if (! odt.getOffset().equals(ZoneOffset.UTC)) {
        System.out.println("Unexpected time zone offset: " + odt);
    }
    // Converts to 2018-12-27
    date = odt.toLocalDate();
    System.out.println(date);