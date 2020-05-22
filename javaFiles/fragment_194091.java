@OutputTimeUnit(TimeUnit.MICROSECONDS)
@BenchmarkMode(Mode.AverageTime)
@Warmup(iterations = 3, time = 2)
@Measurement(iterations = 5, time = 3)
@State(Scope.Thread)
@Threads(1)
@Fork(2)
public class Writing
{
  static final int ARRAY_SIZE = 32768;

  int data[] = new int[ARRAY_SIZE];
  volatile int volatileData[] = new int[ARRAY_SIZE];

  @Setup public void setup() {
    Random rnd = new Random(0);
    for (int c = 0; c < ARRAY_SIZE; ++c) {
      data[c] = rnd.nextInt() % 256;
      volatileData[c] = rnd.nextInt() % 256;
    }
    Arrays.sort(data);
    System.arraycopy(data, 0, volatileData, 0, ARRAY_SIZE);
  }

  @GenerateMicroBenchmark
  public long sum() {
    long sum = 0;
    for (int c = 0; c < ARRAY_SIZE; ++c) if (data[c] >= 128) sum += data[c];
    return sum;
  }

  @GenerateMicroBenchmark
  public long volatileSum() {
    long sum = 0;
    for (int c = 0; c < ARRAY_SIZE; ++c) if (volatileData[c] >= 128) sum += volatileData[c];
    return sum;
  }
}