ZonedDateTime dt1 = ZonedDateTime.parse("2015-03-19T23:00Z");
    ZonedDateTime dt2 = ZonedDateTime.parse("2015-04-05T22:00Z");

    LocalDate startLocalDate = dt1.toLocalDate();
    LocalDate endLocalDate = dt2.toLocalDate();
    long expectedNumDocuments = ChronoUnit.DAYS.between(startLocalDate, endLocalDate);
    System.out.println(expectedNumDocuments); // 17