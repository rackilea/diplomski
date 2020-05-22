object SparkContextLoader {

  val sparkConf = new SparkConf().setMaster("local[" + workers + "]").setAppName("SparkApp")

  val sc = new SparkContext(sparkConf)
}