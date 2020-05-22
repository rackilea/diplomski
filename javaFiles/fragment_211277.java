JavaSparkContext sc = new JavaSparkContext(sparkConf);
        String path = "com.databricks.spark.csv";
        JavaRDD<String> data = sc.textFile(path);
        JavaRDD<LabeledPoint> parsedData = data
                .map(new Function<String, LabeledPoint>() {
                    public LabeledPoint call(String line) throws Exception {
                        String[] parts = line.split(",");
                        return new LabeledPoint(Double.parseDouble(parts[0]),
                                Vectors.dense(Double.parseDouble(parts[1]),
                                        Double.parseDouble(parts[2]),
                                        Double.parseDouble(parts[3])));
                    }
                });