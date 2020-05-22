JavaPairRDD<String, Tuple2<Long, Integer>> final_rdd_records = 
 records_JPRDD.reduceByKey(new Function2<Tuple2<Long, Integer>, Tuple2<Long,
 Integer>, Tuple2<Long, Integer>>() {
    public Tuple2<Long, Integer> call(Tuple2<Long, Integer> v1,
    Tuple2<Long, Integer> v2) throws Exception {
        return new Tuple2<Long, Integer>(v1._1 + v2._1, v1._2+ v2._2);
    }
});