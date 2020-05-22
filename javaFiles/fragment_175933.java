spark.udf().register("my_udf2", my_udf2, DataTypes.StringType);

String[] data = {"abcd", "efgh", "ijkl"};

spark.range(3)
    .withColumn("id", col("id").cast("string"))
    .withColumn("array", functions.array(col("id"), col("id")))
    .withColumn("string_of_arrays",
          functions.callUDF("my_udf2", col("array"), lit(data)))
    .show(false);