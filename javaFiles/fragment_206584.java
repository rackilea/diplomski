JavaRDD<Row> jrdd = preprocessedDocuments.map(f-> RowFactory.create(f.getLabel(), f.getText()));

    StructType schema = new StructType(new StructField[]{
      new StructField("label", DataTypes.DoubleType, false, Metadata.empty()),
      new StructField("sentence", DataTypes.StringType, false, Metadata.empty())
    });
    SQLContext sqlContext = new SQLContext(sc);
    DataFrame sentenceData = sqlContext.createDataFrame(jrdd, schema);
    Tokenizer tokenizer = new Tokenizer().setInputCol("sentence").setOutputCol("words");
    DataFrame wordsData = tokenizer.transform(sentenceData);
    int numFeatures = 20;
    HashingTF hashingTF = new HashingTF()
      .setInputCol("words")
      .setOutputCol("rawFeatures")
      .setNumFeatures(numFeatures);
    DataFrame featurizedData = hashingTF.transform(wordsData);
    DataFrame rescaledData = idfModel.transform(featurizedData);
    JavaRDD<Row> rows = rescaledData.rdd().toJavaRDD();
    JavaRDD<LabeledPoint>  data = rows.map(f -> new LabeledPoint(f.getDouble(0), f.getAs(4)));