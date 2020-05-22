import org.apache.spark.sql.DataFrame;
import static org.apache.spark.sql.functions.*;

DataFrame df = sqlContext.read()
        .format("org.apache.spark.sql.cassandra")
        .option("table", someTable)
        .option("keyspace", someKeyspace)
        .load();

df.groupBy(col("keyColumn"))
        .agg(min("valueColumn"), max("valueColumn"), avg("valueColumn"))
        .show();