@OutputTimeUnit(TimeUnit.MICROSECONDS)
@BenchmarkMode(Mode.AverageTime)
@OperationsPerInvocation(Measure.SIZE)
@Warmup(iterations = 5, time = 100, timeUnit=MILLISECONDS)
@Measurement(iterations = 5, time = 200, timeUnit=MILLISECONDS)
@State(Scope.Thread)
@Threads(1)
@Fork(1)
public class Measure
{
  public static final int SIZE = 1;
  private static final int LIMIT = 50;

  interface PointConsumer { void apply(int x, int y); }
  interface PointIterator { void apply(PointConsumer pc); }

  PointIterator pointIterator;
  List<Point> points;

  @Setup public void setup() {
    pointIterator = pc -> {};
    range(0,LIMIT).forEach(x -> range(0,LIMIT).forEach(y -> {
      final PointIterator pi = pointIterator;
      pointIterator = pc -> { pi.apply(pc); pc.apply(x, y); };
    }));
    points = range(0,LIMIT).mapToObj(i->i).flatMap(
        x -> range(0,LIMIT).mapToObj(y -> new Point(x,y)))
        .collect(toList());
  }

  @Benchmark public int pointIterator() {
    final int sum[] = {0};
    pointIterator.apply((x,y) -> sum[0] += x + y );
    return sum[0];
  }

  @Benchmark public int list() {
    int sum = 0;
    for (Point p : points) sum += p.x + p.y;
    return sum;
  }
}