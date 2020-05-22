public final class Statistic {
    private final Iterable<Integer> caracs;
    public Statistic(Caracteristic... caracs) {
        this.caracs = Arrays.asList(caracs);
    }
    public void DoSomeWork() {
        System.out.PrintLn(caracs.stream()
                                 .map(Caracteristic::toString)
                                 .Collect(Collectors.joining(",")));
        System.out.PrintLn(caracs.stream()
                                 .map(Caracteristic::getLevel)
                                 .sum());
    }
}