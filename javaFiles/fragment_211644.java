import org.apache.spark.sql.SQLContext

SQLContext sqlContext = new SQLContext(sc);
DataFrame df = sqlContext.read()
    .format("com.databricks.spark.csv")
    .option("inferSchema", "true")
    .option("header", "true")
    .option("delimiter","\t")
    .load("cars.csv");

df.select("year", "model").write()
    .format("com.databricks.spark.csv")
    .option("header", "true")
    .save("newcars.csv");