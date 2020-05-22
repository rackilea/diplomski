import org.apache.spark.AccumulatorParam
import scala.collection.mutable.{Map => MMap}

type ACC = MMap[String, Int]

object DummyAccumulatorParam extends AccumulatorParam[ACC] {
  def zero(initialValue: ACC): ACC = {
    initialValue
  }

  def addInPlace(acc: ACC, v: ACC): ACC = {
    v("x") = acc.getOrElse("x", 0) +  v.getOrElse("x", 0)
    v
  }
}