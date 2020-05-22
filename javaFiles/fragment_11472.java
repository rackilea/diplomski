Job job = new Job(conf, "example");
FileInputFormat.addInputPath(job, new Path("PATH to text file"));
job.setInputFormatClass(TextInputFormat.class);
job.setMapperClass(YourMapper.class);
job.setMapOutputKeyClass(Text.class);
job.setMapOutputValueClass(Text.class);
TableMapReduceUtil.initTableReducerJob("hbase_table_name", YourReducer.class, job);
job.waitForCompletion(true);