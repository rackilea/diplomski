import org.apache.spark.sql.SQLContext

SQLContext sqlContext = new SQLContext(sc);
DataFrame df = sqlContext.read()
    .format("com.databricks.spark.xml")
    .option("rowTag", "book")
    .load("books.xml");

df.select("author", "_id").write()
    .format("com.databricks.spark.xml")
    .option("rootTag", "books")
    .option("rowTag", "book")
    .save("newbooks.xml");