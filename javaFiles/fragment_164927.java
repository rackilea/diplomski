// Set SPARK_USER for user who is running SparkContext.
 val sparkUser = Option {
     Option(System.getenv("SPARK_USER")).getOrElse(System.getProperty("user.name"))
  }.getOrElse {
      SparkContext.SPARK_UNKNOWN_USER
  }