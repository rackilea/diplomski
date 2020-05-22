package examples

import java.lang.{Double => JDouble}
import java.util.{List => JList, Map => JMap}
import scala.language.implicitConversions

class Wrapper(val asJava: Inner) {
  implicit def consume(map: JMap[Integer, JList[JDouble]]): Unit = {
    asJava.consume(map)
  }
}