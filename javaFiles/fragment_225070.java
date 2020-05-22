import java.lang.{Double => JDouble}
import scala.jdk.CollectionConverters._
import scala.language.implicitConversions

package object examples {
  implicit class Wrapper(val asJava: Inner) extends AnyVal {
    def consume(map: Map[Int, List[Double]]): Unit = {
      val jmap = map.asInstanceOf[Map[Integer, List[JDouble]]]
      asJava.consume(jmap.map(p => p._1 -> p._2.asJava).asJava)
    }
  }
}