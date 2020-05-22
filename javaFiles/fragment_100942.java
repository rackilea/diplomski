LocalDate dateInWeek1 = LocalDate.of(2020, Month.JANUARY, 3);
    int weekOfYear = dateInWeek1.get(wf.weekOfYear());
    System.out.println(weekOfYear);
    LocalDate dateInPreviousWeek;
    if (weekOfYear == 1) {
        dateInPreviousWeek = dateInWeek1.minusWeeks(1)
                .with(TemporalAdjusters.lastDayOfMonth());
    }
    else {
        dateInPreviousWeek = dateInWeek1.minusWeeks(1);
    }
    System.out.format("%s %2d%n", dateInPreviousWeek, dateInPreviousWeek.get(wf.weekOfYear()));