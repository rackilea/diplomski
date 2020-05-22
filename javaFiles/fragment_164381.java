Date oldfashionedDate = // …;

    OffsetDateTime dateTime = oldfashionedDate.toInstant().atOffset(ZoneOffset.UTC);
    if (! dateTime.toLocalTime().equals(LocalTime.MIDNIGHT)) {
        throw new IllegalStateException("java.util.Date was supposed to be at midnight in UTC but was " + dateTime);
    }
    LocalDate date = dateTime.toLocalDate();
    System.out.println(date);