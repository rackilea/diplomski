JavaPairRDD<Integer, String> pairs = latlong.mapValues(
        new Function<Tuple2<Double, Double>, String>() {
          @Override
          public String call(Tuple2<Double, Double> value) throws Exception {
            return value._1() + "-" + value._2();
          }
        });