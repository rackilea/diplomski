@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
public class SO32462798 {

  List<Integer> list;

  @Setup public void setup() {
    list = new Random().ints(100_000).boxed().collect(toList());
  }

  @Benchmark public int for_loop() {
    int sum = 0;
    for (int i : list) sum += i * i;
    return sum;
  }

  @Benchmark public int summingInt() {
    return list.stream().collect(Collectors.summingInt(x -> x * x));
  }

  @Benchmark public int mapToInt() {
    return list.stream().mapToInt(x -> x * x).sum();
  }

  @Benchmark public int mapToInt_map() {
    return list.stream().mapToInt(x -> x).map(x -> x * x).sum();
  }

  @Benchmark public int map_reduce() {
    return list.stream().map(x -> x * x).reduce((x, y) -> x + y).get();
  }
}