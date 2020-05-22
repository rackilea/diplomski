JavaRDD<Tuple4<Integer, Double, Long, Integer>> firstSortRDD = revenue.sortBy( new Function<Tuple4<Integer, Double, Long, Integer>, Integer>() {
        @Override
        public Integer call(Tuple4<Integer, Double, Long, Integer> value) throws Exception {
            return value._2().intValue();
        }
    }, false, 1 );