public int run(String[] args) throws Exception {

    String driverClassName = DRIVER_CLASS;
    String url = DB_URL;

    if(args.length > 1) {
      driverClassName = args[0];
      url = args[1];
    }

    initialize(driverClassName, url);

    JobConf job = new JobConf(getConf(), DBCountPageView.class);

    job.setJobName("Count Pageviews of URLs");

    job.setMapperClass(PageviewMapper.class);
    job.setCombinerClass(LongSumReducer.class);
    job.setReducerClass(PageviewReducer.class);

    DBConfiguration.configureDB(job, driverClassName, url, "root", "");

    DBInputFormat.setInput(job, AccessRecord.class, "Access"
    , null, "url", AccessFieldNames);

    DBOutputFormat.setOutput(job, "Pageview", PageviewFieldNames);

    job.setMapOutputKeyClass(Text.class);
    job.setMapOutputValueClass(LongWritable.class);

    job.setOutputKeyClass(PageviewRecord.class);
    job.setOutputValueClass(NullWritable.class);

    try {
      JobClient.runJob(job);

      boolean correct = verify();
      if(!correct) {
        throw new RuntimeException("Evaluation was not correct!");
      }
    } finally {
      shutdown();    
    }
    return 0;
}

public static void main(String[] args) throws Exception {
    int ret = ToolRunner.run(new DBCountPageView(), args);
    System.exit(ret);
}