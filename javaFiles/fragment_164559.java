scala> val m = Map("a" -> Seq(1,2,3,4,5).asJava, "b" -> Seq(1,2).asJava).asJava
m: java.util.Map[java.lang.String,java.util.List[Int]] = {a=[1, 2, 3, 4, 5], b=[1, 2]}

scala> m.asScala.collect { case (k, JavaCollection(a, b, rest @ _*)) => k -> (a + b) }
res3: scala.collection.mutable.Map[java.lang.String,Int] = Map(a -> 3, b -> 3)

scala>