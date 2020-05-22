@BenchmarkMode(Array(Mode.AverageTime))
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@State(Scope.Benchmark)
@Fork(3)
@Warmup(iterations = 5)
@Measurement(iterations = 5)
class ScalaBench {

  @Param(Array("1", "5", "10", "15", "20"))
  var t: Int = _

  private def run(): Int = {
    var i = 10
    while(!isEvenlyDivisible(2, i, t))
      i += 2
    i
  }

  @tailrec private def isEvenlyDivisible(i: Int, a: Int, b: Int): Boolean = {
    if (i > b) true
    else (a % i == 0) && isEvenlyDivisible(i + 1, a, b)
  }

  @GenerateMicroBenchmark
  def test(): Int = {
    run()
  }

}