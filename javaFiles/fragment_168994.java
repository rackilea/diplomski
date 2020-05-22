@OutputTimeUnit(TimeUnit.NANOSECONDS)
@BenchmarkMode(Mode.AverageTime)
@Warmup(iterations = 1, time = 1)
@Measurement(iterations = 3, time = 1)
@Threads(1)
@Fork(2)
public class Strings
{
  static final int ITERS = 1_000;
  @GenerateMicroBenchmark
  public void literal() {
    for (int i = 0; i < ITERS; i++) { String s = "test"; }
  }

  @GenerateMicroBenchmark
  public void newString() {
    for (int i = 0; i < ITERS; i++) { String s = new String("test"); }
  }
}