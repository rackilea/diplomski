@OutputTimeUnit(TimeUnit.MICROSECONDS)
@BenchmarkMode(Mode.AverageTime)
@Warmup(iterations = 2, time = 1)
@Measurement(iterations = 3, time = 1)
@State(Scope.Thread)
@Fork(2)
public class Comparison
{
  static final int SIZE = 1<<15;
  final int[] data = new int[SIZE];

  @Setup
  public void setup() {
    int i = 1;
    for (int c = 0; c < SIZE; ++c) data[c] = (i*=611953);
    for (int c = 0; c < SIZE; ++c) data[c] = data[c] >= 128? 128 : 127;
  }

  @GenerateMicroBenchmark
  public long sum() {
    long sum = 0;
    for (int c = 0; c < SIZE; ++c) if (data[c] >= 128) sum += data[c];
    return sum;
  }
}