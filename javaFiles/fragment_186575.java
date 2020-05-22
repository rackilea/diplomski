import static org.apache.spark.sql.functions.split;

public class SparkSample {
    public static void main(String[] args) {
        SparkSession spark = SparkSession
                .builder()
                .appName("SparkSample")
                .master("local[*]")
                .getOrCreate();
        //Read file
        Dataset<Row> ds = spark.read().text("c://tmp//sample.csv").toDF("value");
        ds.show(false);     
        Dataset<Row> ds1 = ds.select(split(ds.col("value"), ",")).toDF("new_value");
        ds1.show(false);
        ds1.printSchema();
    }
}