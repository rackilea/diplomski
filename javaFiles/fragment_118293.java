List<ElementStruct> structElements = dataFrameWithFeatures.javaRDD().map(row -> {
        int artistId = row.getInt(0);
        List<Object> recommendations = row.getList(1);
        return new ElementStruct(artistId, recommendations);
    }).collect();

    List<Recommendation> recommendations = new ArrayList<>();
    for (ElementStruct element : structElements) {
        List<Object> features = element.getFeatures();
        int artistId = element.getArtistId();
        for (int i = 0; i < features.size(); i++) {
            Object o = ((GenericRowWithSchema) features.get(i)).get(0);
            recommendations.add(new Recommendation(artistId, (int) o));
        }
    }
    SparkSession sparkSession = SessionCreator.getOrCreateSparkSession();
    Dataset<Row> decomposedDataframe = sparkSession.createDataFrame(recommendations, Recommendation.class);