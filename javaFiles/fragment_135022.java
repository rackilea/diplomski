@OutputTimeUnit(TimeUnit.NANOSECONDS)
@BenchmarkMode(Mode.AverageTime)
@OperationsPerInvocation(Measure.SIZE)
@Warmup(iterations = 10, time = 100, timeUnit=MILLISECONDS)
@Measurement(iterations = 5, time = 1000, timeUnit=MILLISECONDS)
@State(Scope.Thread)
@Threads(1)
@Fork(1)
public class Measure
{
  public static final int SIZE = 1;

  String toSplit;

  @Setup public void setup() {
    final Random rnd = ThreadLocalRandom.current();
    toSplit = IntStream.range(0, 100)
        .mapToObj(i -> String.valueOf((char)(i < 95? 'A'+rnd.nextInt(20) : '0'+rnd.nextInt(10))))
        .collect(joining());
  }

  static final Pattern regex = Pattern.compile("(?<=\\D)(?=\\d)");

  @Benchmark public String[] regex() {
    return regex.split(toSplit);
  }

  @Benchmark public String[] loop() {
    int i;
    for (i = 0; i < toSplit.length(); i++)
      if (toSplit.charAt(i) >= '0' && toSplit.charAt(i) <= '9')
        break;
    return new String[] { toSplit.substring(0, i), toSplit.substring(i, toSplit.length()) };
  }
}