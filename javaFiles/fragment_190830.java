scala> val a: java.util.Map[String, java.util.Collection[String]] = new java.util.HashMap[String, java.util.Collection[String]]
a: java.util.Map[String,java.util.Collection[String]] = {}

scala> val b = new java.util.ArrayList[String]
b: java.util.ArrayList[String] = []

scala> b.add("hi")
res5: Boolean = true

scala> a.put("a", b)
res6: java.util.Collection[String] = []

scala> import scala.collection.JavaConversions._
import scala.collection.JavaConversions._

scala> val c = a.mapValues(_.toSet)
c: scala.collection.Map[String,scala.collection.immutable.Set[String]] = Map(a -> Set(hi))

scala> c.toMap
res7: scala.collection.immutable.Map[String,scala.collection.immutable.Set[String]] = Map(a -> Set(hi))