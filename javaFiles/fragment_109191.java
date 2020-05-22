import static org.apache.spark.sql.functions.col;
import static org.apache.spark.sql.functions.callUDF;


spark.read().csv("/source/path")
        .withColumn("geohash", callUDF("geohashConverter", col("latitude"), col("longitude")))
        .withColumn("timehash", callUDF("timehashConverter", col("timestamp")))
.write().csv("/path/to/save");