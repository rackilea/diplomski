DF1
  .filter{case(key, value) => myList.contains(key))
  .write
  .partitionBy("key")
  .format("com.databricks.spark.csv")
  .option("header", "true")
  .save("/my/basepath/")