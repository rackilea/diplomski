val awesomeMap = Map("k1" -> "v1",
  "k2" -> 2,
  "k3" -> 10.28,
  "k4" -> List(Map("k4.k1" -> "v3", "k4.k2" -> List(Map("k4.k3" -> "v4")))))

printInKeyValueFormat(awesomeMap)

def printInKeyValueFormat(givenAMap: Map[String, Any]): Unit = {
  givenAMap foreach {
    case (k: String, v: String) => println(k + "=" + v)
    case (k: String, v: Int) => println(k + "=" + v)
    case (k: String, v: Long) => println(k + "=" + v)
    case (k: String, v: Double) => println(k + "=" + v)
    case (k: String, v: List[Map[String, Any]]) => v.foreach(x => printInKeyValueFormat(x))
  }
}