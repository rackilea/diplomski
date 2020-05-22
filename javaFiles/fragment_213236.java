LocalDate now = LocalDate.now();
TemporalField fieldISO = WeekFields.of(Locale.FRANCE).dayOfWeek();
System.out.println(now.with(fieldISO, 1)); // 2015-02-09 (Monday)

TemporalField fieldUS = WeekFields.of(Locale.US).dayOfWeek();
System.out.println(now.with(fieldUS, 1)); // 2015-02-08 (Sunday)