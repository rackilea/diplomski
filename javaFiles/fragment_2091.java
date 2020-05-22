JavaRDD<Tuple2<String, String>> rdd2 = sc
            .wholeTextFiles("path_to_data/*")
            .flatMap(x -> Arrays.asList(x._2.split("\\n"))
                    .stream()
                    .map(w -> new Tuple2<>(x._1, w))
                    .iterator());