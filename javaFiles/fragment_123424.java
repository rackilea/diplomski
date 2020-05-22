JavaPairRDD<Integer, String> swapped = counts.mapToPair(new PairFunction<Tuple2<String, Integer>, Integer, String>() {
           @Override
           public Tuple2<Integer, String> call(Tuple2<String, Integer> item) throws Exception {
               return item.swap();
           }

        });