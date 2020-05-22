Duration<CalendarUnit> d1 = Duration.parseCalendarPeriod("P8W");
System.out.println(d1); // P8W
System.out.println(d1.getPartialAmount(CalendarUnit.WEEKS)); // 8
System.out.println(Duration.Formatter.ofPattern(CalendarUnit.class, "W' weeks'").format(d1)); // 8 weeks
System.out.println(PrettyTime.of(Locale.GERMAN).print(d1)); // 8 Wochen
LocalDate ld = LocalDate.of(2017, 9, 17);
System.out.println(PlainDate.from(ld).plus(d1)); // 2017-11-12
System.out.println(PlainDate.of(2017, 9, 17).plus(d1)); // 2017-11-12

Duration<IsoUnit> d2 = Duration.parsePeriod("P2DT5H10M");
LocalDateTime ldt = LocalDateTime.of(2017, 9, 17, 19, 15);
System.out.println(PlainTimestamp.from(ldt).plus(d2)); // 2017-09-20T00:25
System.out.println(PlainTimestamp.of(2017, 9, 17, 19, 15).plus(d2)); // 2017-09-20T00:25
System.out.println(PrettyTime.of(Locale.GERMAN).print(d2)); // 2 Tage, 5 Stunden und 10 Minuten

Duration<IsoUnit> d3 = Duration.parsePeriod("P0001-01-02T05:10:04");
System.out.println(d3); // P1Y1M2DT5H10M4S
LocalDateTime ldt = LocalDateTime.of(2017, 9, 17, 19, 15);
System.out.println(PlainTimestamp.from(ldt).plus(d3)); // 2018-10-20T00:25:04