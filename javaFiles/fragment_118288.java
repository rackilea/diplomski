private static Dataset readFromCassandraSummary() {
    return getSparkSession().read()
            .format("org.apache.spark.sql.cassandra")
            .option("keyspace", "usage")
            .option("table", "summary")
            .load();
}