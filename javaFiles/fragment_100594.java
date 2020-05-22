import org.apache.spark.sql.functions;

table.groupBy("id").agg(
    functions.count("id").as("count"),
    functions.max("date").as("maxdate")
).show();