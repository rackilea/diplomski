object newDeserializerHelper {
  def main(args: Array[String]): Unit = {
    val config = new java.util.HashMap[String, AnyRef]
    val decoder = new DeserializerHelper(config, classOf[String])
    println("compiles...")
  }
}