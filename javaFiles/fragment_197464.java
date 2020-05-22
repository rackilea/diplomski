public class JavaVectorExample {
    public static void main(String[] args) {
    //SparkSession
    SparkSession spark = SparkSession
      .builder()
      .appName("JavaVectorExample")
      .master("local[2]")
      .getOrCreate();
    //schema
    StructType schema = createStructType(new StructField[]{
      createStructField("id", IntegerType, false),
      createStructField("label", DoubleType, false),
      createStructField("features", new VectorUDT(), false),
    });
    //dataset
    Row row1 = RowFactory.create(0, 1.0, Vectors.dense(0.0, 10.0, 0.5));
    Row row2 = RowFactory.create(1, 1.0, Vectors.dense(1.0, 10.5, 0.5));
    Row row3 = RowFactory.create(0, 1.5, Vectors.dense(0.0, 10.5, 1.0));
    Dataset<Row> dataset = spark.createDataFrame(Arrays.asList(row1,row2,row3), schema);
    dataset.printSchema();
    //groupby
    dataset.groupBy(col("id")).agg(collect_list(col("features"))).show(false);
    spark.stop();
  }
}