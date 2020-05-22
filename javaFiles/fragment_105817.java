Dataset<Row> csv = spark.read().option("inferSchema", "true")
  .csv(inputDf.select("value").as(Encoders.STRING()));
String[] fieldNames = csv.schema().fieldNames();    
VectorAssembler assembler = new VectorAssembler().setInputCols(
  Arrays.copyOfRange(fieldNames, 0, fieldNames.length-1))
  .setOutputCol("indexedFeatures");
Dataset<Row> result = assembler.transform(csv)
  .withColumn("indexedLabel", functions.col(fieldNames[fieldNames.length-1]))
  .select("indexedFeatures", "indexedLabel");