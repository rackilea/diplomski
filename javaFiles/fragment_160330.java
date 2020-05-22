/**
 * Created by RGOVIND on 11/8/2016.
 */

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.PairFunction;
import org.apache.spark.sql.*;
import scala.Tuple2;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SparkMain {
    static public void main(String[] args) {
        SparkConf conf = new SparkConf().setMaster("local").setAppName("Stack Overflow App");
        JavaSparkContext sc = new JavaSparkContext(conf);
        SQLContext sqlContext = new SQLContext(sc);

        List<Tuple2<String, String>> tuples = new ArrayList<Tuple2<String, String>>();
        tuples.add(new Tuple2<String, String>("name1", "caption1"));
        tuples.add(new Tuple2<String, String>("name3", "caption2"));
        tuples.add(new Tuple2<String, String>("name3", "caption3"));

        List<String> descriptions = Arrays.asList(new String[]{"desc1" , "desc2" , "desc3"});

        Encoder<Tuple2<String, String>> nameCaptionEncoder = Encoders.tuple(Encoders.STRING(), Encoders.STRING());
        Dataset<Tuple2<String, String>> nameValueDataSet = sqlContext.createDataset(tuples, nameCaptionEncoder);
        Dataset<String> descriptionDataSet = sqlContext.createDataset(descriptions, Encoders.STRING());
        Dataset<Row> nameValueDataSetWithId = nameValueDataSet.toDF("name","caption").withColumn("id",functions.monotonically_increasing_id()).select("*");
        Dataset<Row> descriptionDataSetId = descriptionDataSet.withColumn("id",functions.monotonically_increasing_id()).select("*");
        nameValueDataSetWithId.join(descriptionDataSetId ,"id").show();
    }
}