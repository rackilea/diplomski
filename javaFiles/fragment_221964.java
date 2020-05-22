JavaPairRDD<Long, MyObject> sortedRDD = rdd.groupBy(/* the first number */)
    .mapPartitionsToPair(x -> {
        List<Tuple2<Long, MyObject>> values = toArrayList(x);
        Collections.sort(values, (x, y) -> x._2.order - y._2.order);

        return values.iterator();
     }, true);