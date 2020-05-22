import org.apache.hadoop.conf.Configuration; import
org.apache.hadoop.io.Text; import org.apache.spark.SparkConf; import
org.apache.spark.api.java.JavaPairRDD; import
org.apache.spark.api.java.JavaSparkContext; import
org.apache.spark.api.java.function.VoidFunction;

import scala.Tuple2;

public class CustomInputFormat {    public static void main(String[]
args) {         
        SparkConf conf = new SparkConf();

        conf.setAppName(args[0]);   
        conf.setMaster("local[*]");         
        final String inputPath = args[1]; 
JavaSparkContext sc = new
JavaSparkContext(conf);         
JavaPairRDD<Text, FileInfoWritable> rdd = sc.newAPIHadoopFile(inputPath, RichFileInputFormat.class,
Text.class,
                FileInfoWritable.class, new Configuration());

        rdd.foreach(new VoidFunction<Tuple2<Text, FileInfoWritable>>() {

            public void call(Tuple2<Text, FileInfoWritable> t) throws
Exception {
                final Text filePath = t._1();
                final String fileContent = t._2().getContent();
                System.out.println("file " + filePath + " has contents= " + fileContent);           }       });

        sc.close();     } }