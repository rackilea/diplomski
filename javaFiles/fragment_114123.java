import static org.apache.spark.sql.functions.*;

spark
 .read
 .format("org.apache.spark.sql.cassandra")
 .options(Map( "table" -> "school", "keyspace" -> "test"))
 .load()
 .groupBy("classroom"))
 .agg(mean("mark1"), stddev("mark1"), mean("mark2"), stddev("mark2"));