SparkSession spark = SparkSession
  .builder()
  .appName("JavaLogisticRegressionSummaryExample")
  .config("spark.sql.warehouse.dir", "/file:C:/temp")//workaround for issue https://issues.apache.org/jira/browse/SPARK-15899
  .master("local[2]")
  .getOrCreate();