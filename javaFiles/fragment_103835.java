package org.undercloud.mapreduce.example3;

import java.io.IOException;

import org.apache.hadoop.io.*;
import org.apache.hadoop.mapred.*;

public class XmlInputFormat extends FileInputFormat {

 public RecordReader getRecordReader(InputSplit input, JobConf job, Reporter reporter)
 throws IOException {

reporter.setStatus(input.toString());
 return new XmlRecordReader(job, (FileSplit)input);
 }