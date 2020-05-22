import static org.apache.spark.sql.functions.*;

Column newCol = when(col("C").equalTo("A"), "X")
    .when(col("C").equalTo("B"), "Y")
    .otherwise("Z");

DataFrame df2 = df1.withColumn("C", newCol);