scala> val a: java.util.Map[String, java.util.Map[String, String]] = new java.util.HashMap[String, java.util.Map[String, String]]
a: java.util.Map[String,java.util.Map[String,String]] = {}


scala> import scala.collection.JavaConversions._
import scala.collection.JavaConversions._

scala> val myScalaMap = a.mapValues(_.toMap)
myScalaMap: scala.collection.Map[String,scala.collection.immutable.Map[String,String]] = Map()