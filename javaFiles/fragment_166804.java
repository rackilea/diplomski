Map<LocalDate, Integer> values = new TreeMap<>();
List<LocalDate> allDates = allSeries.stream().flatMap(s -> s.getEvents().getDate())
    .distinct().collect(toList());

for (LocalDate date : allDates) {
    for (Timeseries series : allSeries) {
        values.merge(date, series.getValueByDate(date), Integer::ad);
    }
}