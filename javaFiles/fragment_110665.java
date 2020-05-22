public class SparkJavaTest {
    public static SparkSession spark = SparkSession
            .builder()
            .appName("JavaSparkTest")
            .master("local")
            .getOrCreate();


    public static void main(String[] args) {

    Dataset<Row> ds1 = spark.read().json("sample.json");

ds1.printSchema();

ds1.select("id", "type", "item.item").show(false);