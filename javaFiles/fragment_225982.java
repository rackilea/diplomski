JavaRDD<List<String>> rdd = ...;

        JavaPairRDD<String, Integer> flatMapToPair = rdd.flatMapToPair(new PairFlatMapFunction<List<String>, String, Integer>() {

            @Override
            public Iterable<Tuple2<String, Integer>> call(List<String> t) throws Exception {
                List<Tuple2<String, Integer>> result = new ArrayList<>();
                for (String str : t) {
                    result.add(new Tuple2<>(str, 1));
                }
                return result;
            }
        });