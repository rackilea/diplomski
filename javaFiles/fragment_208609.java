Configuration conf = new Configuration();
    Job job = new Job(conf,"HDFS Connect");

    FileSystem fs = FileSystem.get(conf);
    Path outputPath = new Path("/user/cloudera/hdfsPath");
    if(fs.exists(outputPath))
        fs.delete(outputPath);