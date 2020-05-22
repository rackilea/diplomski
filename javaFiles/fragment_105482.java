import org.apache.spark.sql.functions.{array, col, explode, lit, when}

val df = Seq(
  (1, "Luke", Some(Array("baseball", "soccer"))),
  (2, "Lucy", None)
).toDF("id", "name", "likes")

df.withColumn("likes", explode(
  when(col("likes").isNotNull, col("likes"))
    // If null explode an array<string> with a single null
    .otherwise(array(lit(null).cast("string")))))