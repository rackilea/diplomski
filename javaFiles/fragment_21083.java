static final Map<String, TemporalAdjuster> ADJUSTERS = new HashMap<>();

ADJUSTERS.put("day", TemporalAdjusters.ofDateAdjuster(d -> d)); // identity
ADJUSTERS.put("week", TemporalAdjusters.previousOrSame(DayOfWeek.of(1)));
ADJUSTERS.put("month", TemporalAdjusters.firstDayOfMonth());
ADJUSTERS.put("year", TemporalAdjusters.firstDayOfYear());