// create a configuration
Configuration conf = new Configuration();
// create a new job based on the configuration
Job job = new Job(conf);
// here you have to put your mapper class
job.setMapperClass(Mapper.class);
// here you have to put your reducer class
job.setReducerClass(Reducer.class);
// here you have to set the jar which is containing your 
// map/reduce class, so you can use the mapper class
job.setJarByClass(Mapper.class);
// key/value of your reducer output
job.setOutputKeyClass(Text.class);
job.setOutputValueClass(Text.class);
// this is setting the format of your input, can be TextInputFormat
job.setInputFormatClass(SequenceFileInputFormat.class);
// same with output
job.setOutputFormatClass(TextOutputFormat.class);
// here you can set the path of your input
SequenceFileInputFormat.addInputPath(job, new Path("files/toMap/"));
// this deletes possible output paths to prevent job failures
FileSystem fs = FileSystem.get(conf);
Path out = new Path("files/out/processed/");
fs.delete(out, true);
// finally set the empty out path
TextOutputFormat.setOutputPath(job, out);

// this waits until the job completes and prints debug out to STDOUT or whatever
// has been configured in your log4j properties.
job.waitForCompletion(true);