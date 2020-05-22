JavaPairRDD<String,String> firstRDD = ....
 JavaPairRDD<String,String> secondRDD =....
 // join both rdd using left outerjoin
 JavaPairRDD<String, Tuple2<String, Optional<Boolean>>> rddWithJoin = firstRDD.leftOuterJoin(secondRDD);


// mapping of join result
JavaPairRDD<String, String> mappedRDD = rddWithJoin
            .mapToPair(tuple -> {
                if (tuple._2()._2().isPresent()) {
                    //do your operation and return
                    return new Tuple2<String, String>(tuple._1(), tuple._2()._1());
                } else {
                    return new Tuple2<String, String>(tuple._1(), "not present");
                }
            });