// df is original dataset
Dataset<Row> df_start = df.groupBy("value").min("start").withColumnRenamed("min(start)", "start").withColumnRenamed("value", "value_start");
Dataset<Row> df_end = df.groupBy("value").max("end").withColumnRenamed("max(end)", "end").withColumnRenamed("value", "value_end");

Dataset<Row> df_combined = df_start.join(df_end, df_start.col("value_start").equalTo(df_end.col("value_end"))).drop("value_end").withColumnRenamed("value_start", "value").orderBy("value");

df_combined.show(false);
+-----+-----+---+
|value|start|end|
+-----+-----+---+
|1    |123  |128|
|2    |128  |400|
|3    |400  |700|
+-----+-----+---+