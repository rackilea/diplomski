System.setProperty("hadoop.home.dir", "C:\\softwares\\Winutils");
        SparkConf conf = new SparkConf().setMaster("local").setAppName("graph");
        JavaSparkContext javaSparkContext = new JavaSparkContext(conf);
        ClassTag<String> stringTag = scala.reflect.ClassTag$.MODULE$.apply(String.class);


        List<Edge<String>> edges = new ArrayList<>();

        edges.add(new Edge<String>(1, 2, "Friend1"));
        edges.add(new Edge<String>(2, 3, "Friend2"));
        edges.add(new Edge<String>(1, 3, "Friend3"));
        edges.add(new Edge<String>(4, 3, "Friend4"));
        edges.add(new Edge<String>(4, 5, "Friend5"));
        edges.add(new Edge<String>(2, 5, "Friend6"));


        JavaRDD<Edge<String>> edgeRDD = javaSparkContext.parallelize(edges);


        Graph<String, String> graph = Graph.fromEdges(edgeRDD.rdd(), "",StorageLevel.MEMORY_ONLY(), StorageLevel.MEMORY_ONLY(), stringTag, stringTag);


        graph.vertices().toJavaRDD().collect().forEach(System.out::println);