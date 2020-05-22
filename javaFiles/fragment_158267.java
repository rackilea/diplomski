JavaRDD<Tuple2<Integer, Integer>> trdd = cartesian.map(new Function<Tuple2<DateTime, Integer>, Tuple2<Integer, Integer>>() {
        @Override
        public Tuple2<Integer, Integer> call(Tuple2<DateTime, Integer> tuple2) throws Exception {
            return new Tuple2<Integer, Integer>(tuple2._1(), tuple2._2());
        }
    });
CassandraJavaPairRDD<Tuple2<Integer, Integer>, Tuple2<Integer, String>> joinedRDD =
     trdd.joinWithCassandraTable("test", "jtest",
     someColumns("p1", "p2"), someColumns("p1", "p2"),
     mapRowToTuple(Integer.class, String.class), mapTupleToRow(Integer.class));
// perform counting here...