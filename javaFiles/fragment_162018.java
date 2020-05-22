package org.woopi.stackoverflow.q22853574;

import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.lib.input.*;
import org.apache.hadoop.mapreduce.lib.output.*;
import org.apache.hadoop.mapreduce.*;
import org.apache.hadoop.fs.Path;
import java.io.IOException;
import org.apache.hadoop.conf.Configuration;

public class MapReduceJob {

  public static class MapClass extends Mapper<Object, Text, Text, LongWritable> {

    public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
        // your map code goes here
        String[] fields = value.toString().split(",");

        for(String str : fields) {
            context.write(new Text(str), new LongWritable(1L));
        }
    }
  }

    public int run(String args[]) throws Exception {
        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf);
        job.setJarByClass(MapReduceJob.class);

        job.setMapperClass(MapClass.class);

        FileInputFormat.setInputPaths(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));

        job.setJobName("MapReduceJob");
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(LongWritable.class);
        job.setNumReduceTasks(0);
        job.setInputFormatClass(TextInputFormat.class);
        boolean success = job.waitForCompletion(true);
        return success ? 0 : 1;
    }

  public static void main(String args[]) throws Exception {
    MapReduceJob j = new MapReduceJob();
    int ret = j.run(args);
    System.exit(ret);
  }