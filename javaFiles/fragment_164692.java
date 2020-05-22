import static org.apache.spark.sql.functions.col;
import static org.apache.spark.sql.functions.callUDF;
import scala.collection.JavaConversions;

//register UDF
spark.udf().register("getValue", getValue, DataTypes.createArrayType(DataTypes.IntegerType));

//Call UDF
Dataset<Row> ds1  = ds.select(col("*"), callUDF("getValue", col("value")).as("udf-value"));
ds1.show();