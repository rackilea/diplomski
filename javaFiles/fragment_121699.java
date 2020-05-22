public class SomeJob extends Configured implements Tool {

    private static final String JOB_NAME = "My Job";

    /**
     * This is Mapper.
     */
    public static class MapJob extends Mapper<LongWritable, Text, Text, Text> {

        private Text outputKey = new Text();
        private Text outputValue = new Text();

        @Override
        protected void setup(Context context) throws IOException, InterruptedException {

            // Get the cached file
            Path file = DistributedCache.getLocalCacheFiles(context.getConfiguration())[0];

            File fileObject = new File (file.toString());
            // Do whatever required with file data
        }

        @Override
        public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
            outputKey.set("Some key calculated or derived");
            outputVey.set("Some Value calculated or derived");
            context.write(outputKey, outputValue);
        }
        }

    /**
     * This is Reducer.
     */
    public static class ReduceJob extends Reducer<Text, Text, Text, Text> {

    private Text outputKey = new Text();
    private Text outputValue = new Text();

        @Override
        protected void reduce(Text key, Iterable<Text> values, Context context) throws IOException,
                InterruptedException {
            outputKey.set("Some key calculated or derived");
            outputVey.set("Some Value calculated or derived");
            context.write(outputKey, outputValue);
        }
    }

    @Override
    public int run(String[] args) throws Exception {

        try {
            Configuration conf = getConf();
            DistributedCache.addCacheFile(new URI(args[2]), conf);
            Job job = new Job(conf);

            job.setJarByClass(TaxonomyOverviewReportingStepOne.class);
            job.setJobName(JOB_NAME);

            job.setMapperClass(MapJob.class);
            job.setReducerClass(ReduceJob.class);
            job.setOutputKeyClass(Text.class);
            job.setOutputValueClass(Text.class);

            job.setInputFormatClass(TextInputFormat.class);
            job.setOutputFormatClass(TextOutputFormat.class);
            job.setMapOutputKeyClass(Text.class);
            job.setMapOutputValueClass(Text.class);
            FileInputFormat.setInputPaths(job, args[0]);
            FileOutputFormat.setOutputPath(job, new Path(args[1]));

            boolean success = job.waitForCompletion(true);
            return success ? 0 : 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 1;
        }

    }

    public static void main(String[] args) throws Exception {

        if (args.length < 3) {
            System.out
                    .println("Usage: SomeJob <comma sparated list of input directories> <output dir> <cache file>");
            System.exit(-1);
        }

        int result = ToolRunner.run(new TaxonomyOverviewReportingStepOne(), args);
        System.exit(result);
    }

}