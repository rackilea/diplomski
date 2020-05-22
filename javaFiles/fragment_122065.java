import static org.apache.spark.sql.functions.col;
import org.apache.spark.ml.image.ImageSchema;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.opencv.core.Core;

public class ReadImageExample {
    public static void main(String[] args) {
        SparkSession spark = SparkSession.builder().appName("ReadImageExample").master("local").getOrCreate();
        Dataset<Row> ds = ImageSchema.readImages("C:\\temp", spark, false, 0, true, 1.0, 1);
        ds.printSchema();
        ds.select(col("image.width"), col("image.height"), col("image.mode")).show();
    }
}