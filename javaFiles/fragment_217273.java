@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@State(Scope.Thread)
@Warmup(iterations = 5, time = 500, timeUnit = TimeUnit.MILLISECONDS)
@Measurement(iterations = 5, time = 1000, timeUnit = TimeUnit.MILLISECONDS)
@Fork(1)
public class SO24003674 {

  private int p = 3002;

  @GenerateMicroBenchmark
  public boolean limit() {
    return LongStream.iterate(1, n -> n + 1).limit(5000)
              .anyMatch(n -> isPerfectCube((n * n * n) + ((n * n) * p)));
  }

  @GenerateMicroBenchmark
  public boolean noLimit() {
    return LongStream.iterate(1, n -> n + 1)
              .anyMatch(n -> isPerfectCube((n * n * n) + ((n * n) * p)));
  }

  private static boolean isPerfectCube(long n) {
    long tst = (long) (Math.cbrt(n) + 0.5);
    return tst * tst * tst == n;
  }
}