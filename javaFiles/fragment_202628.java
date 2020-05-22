package com.stackoverflow.answers.mapreduce;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class SourceFileMapper extends Mapper<LongWritable, Text, IntWritable, Text> {

    private static final String DEFAULT_DELIMITER = "\t";

    private IntWritable keyToEmit = new IntWritable();
    private Text valueToEmit = new Text();

    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String line = value.toString();
        keyToEmit.set(Integer.parseInt(line.split(DEFAULT_DELIMITER)[0]));
        valueToEmit.set(line.split(DEFAULT_DELIMITER)[1]);
        context.write(keyToEmit, valueToEmit);
    }

}