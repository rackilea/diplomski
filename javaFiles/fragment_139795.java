SparkSession spark = SparkSession.builder()
                  .master("local")
                  .appName("CSV Processor")
                  .getOrCreate();
Dataset<Row> df = spark.read()
                  .option("header", "true")
                  .csv("input.csv");
df.printSchema();
Dataset<Row> grouped = df.groupBy("Name")
       .count()
       .sort(org.apache.spark.sql.functions.col("count").desc())
       .limit(500);
grouped.show();
grouped.coalesce(1)
       .write()
       .mode("overwrite")
       .option("header", "true")
       .csv("output.csv");