import com.thoughtworks.xstream.XStream
import com.thoughtworks.xstream.converters.reflection.PureJavaReflectionProvider

object Hello extends App {
  val xstream = new XStream(new PureJavaReflectionProvider())
  xstream.alias("MyData", classOf[MyData])
  val output = xstream.fromXML("<MyData><id>This should fill in</id></MyData>")
  println(output)
}

case class MyData(id: String = "", var b: String = "") 
{
   def this() = this("", "")
}