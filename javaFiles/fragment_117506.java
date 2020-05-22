@State(Benchmark)
public class StrComp {

    @Param({"Queen", "queen", "King"})
    public String input;

    @Benchmark
    public boolean eqIgnoreCase() {
        return input.equalsIgnoreCase("queen");
    }

    @Benchmark
    public boolean eqToLower() {
        return input.toLowerCase().equals("queen");
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(".*StrComp.*")
                .mode(Mode.AverageTime)
                .timeUnit(TimeUnit.NANOSECONDS)
                .forks(5)
                .warmupIterations(10)
                .measurementIterations(10)
                .build();

        new Runner(opt).run();
    }
}