private static void getDays(DateTime todayDate, DateTime expiryDate, int interval) {
           int numberOfDays = Days.daysBetween(new LocalDate(todayDate), new LocalDate(expiryDate)).getDays();
           Range<Integer> open = Range.closed(1, numberOfDays/interval);
           ImmutableList<Integer> integers = ContiguousSet.create(open, DiscreteDomain.integers()).asList();
           FluentIterable.from(integers).transform(new ConvertToDate(interval)).toList().forEach(System.out::println);
}

private static class ConvertToDate implements Function<Integer, DateTime> {
    private final int interval;

    public ConvertToDate(int interval) {
        this.interval = interval;
    }

    @Override
    public DateTime apply(Integer integer) {
        return DateTime.now().plusDays(integer* interval);
    }
}