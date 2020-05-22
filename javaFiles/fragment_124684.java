VectorAssembler assembler = new VectorAssembler()
.setInputCols(new String[]{"size", "records"})
.setOutputCol("features");

 Dataset<Row> vectorized_df = assembler.transform(df)

 KMeans kmeans = new KMeans().setK(2).setSeed(1L);
 KMeansModel model = kmeans.fit(vectorized_df);