@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class BigDecimalBenchmark {

  static int i = 1024;

  @Benchmark
  public BigDecimal constructor() {
    return new BigDecimal(foo());
  }

  @Benchmark
  public BigDecimal localVariable() {
    int hash = foo();
    return new BigDecimal(hash);
  }

  private static int foo() {
    return i;
  }

}