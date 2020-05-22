@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
public class SO34929316 {

  @Param({"1", "1000", "100000", "1000000", "10000000"}) int size;
  long[] array;

  @Setup(Level.Iteration)
  public void setup(){
    array = new long[size];
  }

  @Benchmark
  public void setAll(Blackhole bh) {
    Arrays.setAll(array, n -> n * n * 11 + n * 7);
    bh.consume(array);
  }

  @Benchmark
  public void parallelSetAll(Blackhole bh) {
    Arrays.parallelSetAll(array, n -> n * n * 11 + n * 7);
    bh.consume(array);
  }
}