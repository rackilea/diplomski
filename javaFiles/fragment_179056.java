import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.streaming.Durations;
import org.apache.spark.streaming.api.java.JavaInputDStream;
import org.apache.spark.streaming.api.java.JavaPairDStream;
import org.apache.spark.streaming.api.java.JavaStreamingContext;

import scala.Tuple2;

public class SparkStreamTest {
    public static void main(String[] args) throws Exception {
        SparkConf sc = new SparkConf().setAppName("SparkStreamTest").setMaster("local[*]");;
        JavaStreamingContext jssc = new JavaStreamingContext(sc, Durations.seconds(5));
        //first data list
        List<Tuple2<String, String>> data1 = new ArrayList<Tuple2<String, String>>();
        data1.add(new Tuple2<String, String>("K1", "ABC"));
        data1.add(new Tuple2<String, String>("K2", "DE"));
        data1.add(new Tuple2<String, String>("K1", "F"));
        data1.add(new Tuple2<String, String>("K3", "GHI"));
        //javaRDD1
        JavaRDD<Tuple2<String, String>> javaRDD1 = jssc.sparkContext().parallelize(data1);
        //second data list
        List<Tuple2<String, String>> data2 = new ArrayList<Tuple2<String, String>>();
        data2.add(new Tuple2<String, String>("K1", "123"));
        data2.add(new Tuple2<String, String>("K2", "256"));
        data2.add(new Tuple2<String, String>("K7", "0"));
        //javaRDD2
        JavaRDD<Tuple2<String, String>> javaRDD2 = jssc.sparkContext().parallelize(data2);
        //Queue
        Queue<JavaRDD<Tuple2<String, String>>> inputQueue = new LinkedList<JavaRDD<Tuple2<String, String>>>();
        inputQueue.add(javaRDD1);
        inputQueue.add(javaRDD2);
        //stream
        JavaInputDStream<Tuple2<String, String>> javaDStream = jssc.queueStream(inputQueue, true);
        JavaPairDStream<String,String> javaPairDStream = javaDStream.mapToPair(tuple -> new Tuple2(tuple._1().toLowerCase(),tuple._2()));
        //print
        javaPairDStream.print();
        //start
        jssc.start();
        jssc.awaitTermination();
    }
}