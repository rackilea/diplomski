WeekFields wf = WeekFields.of(Locale.getDefault());

    int week = 1; // week of year

    LocalDate startDate = LocalDate.now(ZoneOffset.UTC)
            .with(wf.weekOfWeekBasedYear(), week)
            .with(wf.dayOfWeek(), 1);
    Instant startInstant = startDate.atStartOfDay(ZoneOffset.UTC).toInstant();
    LocalDate endDate = startDate.plusWeeks(1);
    Instant endInstant = endDate.atStartOfDay(ZoneOffset.UTC).toInstant();

    System.out.println("" + startInstant + " - " + endInstant);