public static void aggregateSessionEvents(SparkContext sparkContext) {
    JavaRDD<Data> datas = javaFunctions(sparkContext).cassandraTable("test", "data",
            mapRowTo(Data.class));
    JavaPairRDD<String, String> pairDatas = datas
            .mapToPair(data -> new Tuple2<>(data.getKey(), data.getValue()));
    pairDatas.reduceByKey((value1, value2) -> value1 + "," + value2);
    sparkContext.stop();
}