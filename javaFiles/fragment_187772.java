Dataset<Row> inputDs = spark.read().json(sc.parallelize(Arrays.asList(
        "{\"lablel\": 1.0, \"features\": \"foo\"}"
)));

inputDs.map(new MapFunction<Row, Row>() {
    public Row call(Row row) {
        return RowFactory.create(1.0, Vectors.dense(1.0, 2.0));
    }
}, encoder);