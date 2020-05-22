JavaPairDStream<String,String> samples = lines.flatMapToPair(new PairFlatMapFunction<String,String, String>() {
            public Iterator<Tuple2<String,String>> call(String s) throws Exception {
                return Arrays.asList(new Tuple2<String, String>(//Some logic on my data//).iterator();
            }
        });


JavaPairDStream<Tuple2<String,String>, Integer> samplePairs = samples.mapToPair(
               new PairFunction<Tuple2<String,String>, Tuple2<String,String>, Integer>() {
                    public Tuple2<Tuple2<String,String>, Integer> call(Tuple2<String,String> t) {
                        return new Tuple2<Tuple2<String,String>, Integer>(t, 1);
                    }
                });

        JavaPairDStream<String, Integer> countErrors = samplePairs.filter(new Function<Tuple2<Tuple2<String,String>,Integer>,Boolean>() {
            public Boolean call(Tuple2<Tuple2<String,String>, Integer> t)
            {
               return (t._1._2.equals("Error"));
           }}).mapToPair(new PairFunction<Tuple2<Tuple2<String,String>,Integer>, String, Integer>() {
            public Tuple2<String,Integer> call(Tuple2<Tuple2<String,String>,Integer> t) {
                return new Tuple2(t._1._1,t._2);
            }
        }).reduceByKeyAndWindow(new Function2<Integer, Integer, Integer>() {
            public Integer call(Integer i1, Integer i2) {
                return i1 + i2;
            }}, Durations.seconds(30), Durations.seconds(1));

        JavaPairDStream<String, Integer> countSuccess= samplePairs.filter(new Function<Tuple2<Tuple2<String,String>,Integer>,Boolean>() {
            public Boolean call(Tuple2<Tuple2<String,String>, Integer> t)
            {
                return (t._1._2.equals("Success"));
            }}).mapToPair(new PairFunction<Tuple2<Tuple2<String,String>,Integer>, String, Integer>() {
            public Tuple2<String,Integer> call(Tuple2<Tuple2<String,String>,Integer> t) {
                return new Tuple2(t._1._1,t._2);
            }
        }).reduceByKeyAndWindow(new Function2<Integer, Integer, Integer>() {
            public Integer call(Integer i1, Integer i2) {
                return i1 + i2;
            }}, Durations.seconds(30), Durations.seconds(1));

        JavaPairDStream<String,Tuple2<Optional<Integer>,Optional<Integer>>> countPairs = countSuccess.fullOuterJoin(countErrors);

        JavaPairDStream<String, Double> mappedRDD = countPairs
                .mapToPair(new PairFunction<Tuple2<String, Tuple2<Optional<Integer>, Optional<Integer>>>, String, Double>() {
                    public Tuple2<String, Double> call(Tuple2<String, Tuple2<Optional<Integer>, Optional<Integer>>> stringTuple2Tuple2) throws Exception {
                        if ((stringTuple2Tuple2._2()._2().isPresent()) && (stringTuple2Tuple2._2()._1().isPresent())) {
                            return new Tuple2<String, Double>(stringTuple2Tuple2._1(), ((double)stringTuple2Tuple2._2()._1().get() /
                                    ((double)stringTuple2Tuple2._2()._2().get()+(double)stringTuple2Tuple2._2()._1().get())));
                        } else if (stringTuple2Tuple2._2()._2().isPresent()){
                            return new Tuple2<String, Double>(stringTuple2Tuple2._1(), 1.0);
                        } else {
                            return new Tuple2<String, Double>(stringTuple2Tuple2._1(), 0.0);
                        }
                    }
                });