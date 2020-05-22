JavaPairDStream<Integer,String> sortedStream = swappedPair.transformToPair(
     new Function<JavaPairRDD<Integer,String>, JavaPairRDD<Integer,String>>() {
         @Override
         public JavaPairRDD<Integer,String> call(JavaPairRDD<Integer,String> jPairRDD) throws Exception {
                    return jPairRDD.sortByKey(false);
                  }
              });

sortedStream.print();