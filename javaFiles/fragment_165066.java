VectorAssembler assembler = new VectorAssembler()
  .setInputCols(new String[] { "feature1", "feature2" })
  .setOutputCol("indexedFeatures");
Dataset<Row> result = assembler.transform(featuresAndLabelData)
  .withColumn("indexedLabel", functions.col("label").cast("double"))
  .select("indexedFeatures", "indexedLabel");