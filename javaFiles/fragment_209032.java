JavaPairRDD<String, Tuple2<Long, Integer>> records_JPRDD = 
rdd_records.mapToPair(new
  PairFunction<Record, String, Tuple2<Long, Integer>>(){
    public Tuple2<String, Tuple2<Long, Integer>> call(Record record){
      Tuple2<String, Tuple2<Long, Integer>> t2 = 
      new Tuple2<String, Tuple2<Long,Integer>>(
        record.Department + record.Designation + record.State,
        new Tuple2<Long, Integer>(record.costToCompany,1)
      );
      return t2;
}