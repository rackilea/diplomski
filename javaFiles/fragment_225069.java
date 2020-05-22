package examples

import java.lang.{Double => JDouble}
import scala.jdk.CollectionConverters._
import scala.language.implicitConversions

class Wrapper(val asJava: Inner) {
  implicit def consume(map: Map[Int, List[Double]]): Unit = {
    val jmap = map.asInstanceOf[Map[Integer, List[JDouble]]]
    asJava.consume(jmap.map(p => p._1 -> p._2.asJava).asJava)
  }
}