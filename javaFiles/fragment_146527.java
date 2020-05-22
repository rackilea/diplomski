LocalDate firstPayment = LocalDate.of(2015, Month.JANUARY, 1);
    // The first payment in May 2018 must be within the first 14 days of May.
    long weeksAfterFirst
            = ChronoUnit.WEEKS.between(firstPayment, LocalDate.of(2018, Month.MAY, 14));
    // We need an even number of weeks
    if (weeksAfterFirst % 2 != 0) {
        weeksAfterFirst--;
    }
    LocalDate firstInMay = firstPayment.plusWeeks(weeksAfterFirst);
    System.out.println(firstInMay);