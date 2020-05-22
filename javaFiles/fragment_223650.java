import org.openjdk.jmh.annotations._

import scala.collection.JavaConversions._

@State(Scope.Thread)
class WrapperBenchmark {

  val unwrappedCollection = (1 to 100).toSet
  val wrappedCollection: java.util.Set[Int] = (1 to 100).toSet[Int]

  @Benchmark
  def measureUnwrapped: Int = unwrappedCollection.size

  @Benchmark
  def measureWrapped: Int = wrappedCollection.size()
}