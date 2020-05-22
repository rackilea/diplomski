private static void moreEfficientJoin() {
    SparkConf conf = new SparkConf().setAppName("Simple Application")
                                    .setMaster("local[*]")
                                    .set("spark.cassandra.connection.host", "localhost")
                                    .set("spark.driver.allowMultipleContexts", "true");
    JavaSparkContext sc = new JavaSparkContext(conf);

    JavaRDD<DataKey> nameIndexRDD = sc.parallelize(javaFunctions(sc).cassandraTable("my_keyspace", "name", mapRowTo(DataKey.class))
                                                                    .where("name = 'John'")
                                                                    .collect());

    JavaRDD<Data> dataRDD = javaFunctions(nameIndexRDD).joinWithCassandraTable("my_keyspace", "data", allColumns, someColumns("timestamp", "id"), mapRowTo(Data.class), mapToRow(DataKey.class))
                                                       .map(new Function<Tuple2<DataKey, Data>, Data>() {
                                                           @Override
                                                           public Data call(Tuple2<DataKey, Data> v1) throws Exception {
                                                               return v1._2();
                                                           }
                                                       });
    List<Data> data = dataRDD.collect();
}