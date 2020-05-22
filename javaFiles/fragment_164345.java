import static org.apache.spark.sql.functions.col;
import static org.apache.spark.sql.functions.callUDF;
import scala.collection.JavaConversions;

// register UDF
spark.udf().register("getValue", getValue, DataTypes.createArrayType(DataTypes.DoubleType));

// Call UDF
Dataset<Row> ds2 = ds1.select(col("*"), callUDF("getValue", col("value")).as("udf-value"));
ds2.show(false);