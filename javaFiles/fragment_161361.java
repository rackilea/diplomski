import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.io.NullWritable;
import org.apache.avro.mapred.AvroKey;
import org.apache.spark.api.java.JavaPairRDD;
import scala.Tuple2;

   .  .  .  .  .

// Serializing to AVRO
JavaPairRDD<AvroKey<Article>, NullWritable> javaPairRDD = processingFiles.mapToPair(r -> {    
    return new Tuple2<AvroKey<Article>, NullWritable>(new AvroKey<Article>(r), NullWritable.get());
});
Job job = AvroUtils.getJobOutputKeyAvroSchema(Article.getClassSchema());
javaPairRDD.saveAsNewAPIHadoopFile(outputDataPath, AvroKey.class, NullWritable.class, AvroKeyOutputFormat.class, 
        job.getConfiguration());