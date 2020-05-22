LocalDate today = LocalDate.now(ZoneId.of("Europe/Istanbul"));

    int weekNumber = today.get(WeekFields.ISO.weekOfYear());
    System.out.println("Week no. " + weekNumber);

    LocalDate[] days = today.datesUntil(today.with(TemporalAdjusters.next(DayOfWeek.MONDAY)))
            .toArray(LocalDate[]::new);
    System.out.println(Arrays.toString(days));