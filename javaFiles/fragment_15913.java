Configuration config = new Configuration();
    config.set("mapreduce.input.keyvaluelinerecordreader.key.value.separator", " ");
    config.set("mapred.textoutputformat.separator", " --> ");
    config.set("fs.file.impl", "com.assignment.WinLocalFileSystem");

    String inputPath="In\\VISA_Details.csv";
    Path inPath=new Path(inputPath);
    String outputPath = "C:\\Users\\Desktop\\Hadoop Learning\\output\\run1";
    Path outPath=new Path(outputPath);

    Job job = new Job(config,"VISA: Total count on each day");
    job.setInputFormatClass(TextInputFormat.class);
    job.setOutputFormatClass(TextOutputFormat.class);

    job.setMapOutputKeyClass(Text.class);
    job.setMapOutputValueClass(Text.class);
    job.setOutputKeyClass(Text.class);
    job.setOutputValueClass(Text.class);

    job.setMapperClass(VisaMapper.class);
    job.setReducerClass(VisaReducer.class);

    FileInputFormat.setInputPaths(job, inPath );
    FileOutputFormat.setOutputPath(job, outPath);

    System.out.println(job.waitForCompletion(true));