import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

public class JavaShakespeare {

  public static void main(String[] args) {
    SparkSession spark = SparkSession.builder()
        .appName("spark-bigquery-demo")
        .getOrCreate();

    // Use the Cloud Storage bucket for temporary BigQuery export data used
    // by the connector. This assumes the Cloud Storage connector for
    // Hadoop is configured.
    String bucket = spark.sparkContext().hadoopConfiguration().get("fs.gs.system.bucket");
    spark.conf().set("temporaryGcsBucket", bucket);

    // Load data in from BigQuery.
    Dataset<Row> wordsDF = spark.read().format("bigquery")
        .option("table", "publicdata.samples.shakespeare").load().cache();
    wordsDF.show();
    wordsDF.printSchema();
    wordsDF.createOrReplaceTempView("words");

    // Perform word count.
    Dataset<Row> wordCountDF = spark.sql(
        "SELECT word, SUM(word_count) AS word_count FROM words GROUP BY word");

    // Saving the data to BigQuery
    wordCountDF.write().format("bigquery").option("table", "wordcount_dataset.wordcount_output")
        .save();
  }
}