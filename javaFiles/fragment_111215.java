scala> val lb: ListBuffer[Array[String]] = new ListBuffer[Array[String]]()
lb: scala.collection.mutable.ListBuffer[Array[String]] = ListBuffer()

scala> for (i <- 1 until 30){lb += Array(i.toString)}

scala> lb.toList
res5: List[Array[String]] = List(Array(1), Array(2), Array(3), Array(4), Array(5), Array(6), Array(7), Array(8), Array(9), Array(10), Array(11), Array(12), Array(13), Array(14), Array(15), Array(16), Array(17), Array(18), Array(19), Array(20), Array(21), Array(22), Array(23), Array(24), Array(25), Array(26), Array(27), Array(28), Array(29))