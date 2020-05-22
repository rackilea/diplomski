String filterFromDate = "26122019";
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyy");
    OffsetDateTime fromDate = LocalDate.parse(filterFromDate, formatter)
            .atStartOfDay(ZoneOffset.UTC)
            .toOffsetDateTime();
    System.out.println(fromDate);