java.util.function.Function<Double, Tuple2<Double, Integer>> createAcc =
    x -> new Tuple2<Double, Integer>(x, 1);

Function2<Tuple2<Double, Integer>, Double, Tuple2<Double, Integer>>  addAndCount = 
    (Tuple2<Double, Integer> x, Double y) -> {  return new Tuple2(x._1()+y, x._2()+1 );   };

Function2<Tuple2<Double, Integer>, Tuple2<Double, Integer>, Tuple2<Double, Integer>>  combine = 
    (Tuple2<Double, Integer> x, Tuple2<Double, Integer> y) -> {  return new Tuple2(x._1()+y._1(), x._2()+y._2() );   };

JavaPairRDD<Integer, Tuple2<Double, Integer>> avgCounts = 
    pairs.combineByKey(createAcc, addAndCount, combine);