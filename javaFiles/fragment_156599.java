String dateString = "2018-01-01";
    OffsetDateTime odt = LocalDate.parse(dateString)
            .atStartOfDay()
            .atOffset(ZoneOffset.UTC);

    System.out.println(odt);