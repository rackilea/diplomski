object Counter {
    def main(args: Array[String]): Unit = {
      val conf = new SparkConf().setAppName("Simple Application").setMaster("local[4]")
      val sc = new SparkContext(conf)
      val counter = sc.accumulator(0)
      val data = Array(1, 2, 3, 4, 5)
      val rdd = sc.parallelize(data)
      rdd.foreach(x => counter += x)
      println(s"Counter value: $counter")
    }
}