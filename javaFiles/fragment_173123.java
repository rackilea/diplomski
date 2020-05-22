JavaRDD<Tuple2<Long, String>> vertices = sc.parallelize(new 
     Lists.newArrayList({
      Tuple2(1L, "one"), Tuple2(2L, "two"),
      Tuple2(3L, "three"), Tuple2(4L, "four")})
    );

    JavaRDD<Edge> relationships =
      sc.parallelize(Lists.newArrayList({
        Edge(1L, 2L, 1.0), Edge(1L, 4L, 2.0),
        Edge(2L, 4L, 3.0), Edge(3L, 1L, 1.0),
        Edge(3L, 4L, 5.0)}
      );

Graph(relationships, vertices, StorageLevel.MEMORY_ONLY(), StorageLevel.MEMORY_ONLY(), stringTag, stringTag);