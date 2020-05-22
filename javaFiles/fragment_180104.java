Dataset<Row> df_dhv_grouped = df.groupBy(
                        col("day"), col("vendor_id"), col("hour")).count();

Dataset<Row> df_max_hours =df_dhv_grouped.withColumn("max_drives_hour",max("count")
                              .over(Window.partitionBy("day","vendor_id")));

df_max_hours.filter(col("count").equalTo(col("max_drives_hour")))
                        .orderBy(col("day").asc(), col("vendor_id").asc()).show();