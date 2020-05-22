public class Hash {
    public static void main(String[] args) {
        String path = "in/prueba.csv";

        UDF2 geohashConverter = new UDF2<Long, Long, String>() {

            public String call(Long latitude, Long longitude) throws Exception {
                // convert here
                return "calculate_hash";
            }
        };

        UDF1 timehashConverter = new UDF1<Long, String>() {

            public String call(Long timestamp) throws Exception {
                // convert here
                return "calculate_hash";
            }
        };

        SparkSession spark = SparkSession
                .builder()
                .appName("Java Spark SQL Example")
                .config("spark.master", "local")
                .getOrCreate();

        spark.udf().register("geohashConverter", geohashConverter, DataTypes.StringType);
        spark.udf().register("timehashConverter", timehashConverter, DataTypes.StringType);

        spark
                .read()
                .format("com.databricks.spark.csv")
                .option("header", "true")
                .load(path)
                .withColumn("geohash", callUDF("geohashConverter", col("_c6"), col("_c7")))
                .withColumn("timehash", callUDF("timehashConverter", col("_c1")))
                .write().csv("resultados");
    }
}