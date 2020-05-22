JavaPairRDD<Integer, Long> rdd1 = sc.parallelize(Arrays.asList(1, 2, 1,   0)).zipWithIndex();
rdd1.mapToPair(x -> 
        {
            if (x._1 == 2) 
                return new Tuple2<Integer, Long>(x._1*x._1, x._2); 
            else 
                return new Tuple2<Integer, Long>(x._1, x._2); 
        }).foreach(x -> System.out.println(x));