public class WordCount {
    /**
     * The map class of WordCount.
     */
    public static class TokenCounterMapper extends
            Mapper<Object, Text, Text, IntWritable> {

        private final static IntWritable one = new IntWritable(1);
        private Text word = new Text();

        public void map(Object key, Text value, Context context)
                throws IOException, InterruptedException {              

            StringTokenizer itr = new StringTokenizer(value.toString());
            while (itr.hasMoreTokens()) {
                word.set(itr.nextToken());
                context.write(word, one);
            }
        }
    }

    /**
     * The reducer class of WordCount
     */
    public static class TokenCounterReducer extends
            Reducer<Text, IntWritable, Text, IntWritable> {
        public void reduce(Text key, Iterable<IntWritable> values,
                Context context) throws IOException, InterruptedException {
            int sum = 0;
            for (IntWritable value : values) {
                sum += value.get();
            }
            context.write(key, new IntWritable(sum));
        }
    }

    /**
     * The main entry point.
     */
    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();
        conf.addResource(new Path("/Users/miqbal1/hadoop-eco/hadoop-1.1.2/conf/core-site.xml"));
        conf.addResource(new Path("/Users/miqbal1/hadoop-eco/hadoop-1.1.2/conf/hdfs-site.xml"));
        conf.set("fs.default.name", "hdfs://localhost:9000");
        conf.set("mapred.job.tracker", "localhost:9001");
        Job job = new Job(conf, "WordCount");
        job.setJarByClass(WordCount.class);
        job.setMapperClass(TokenCounterMapper.class);
        job.setReducerClass(TokenCounterReducer.class);
        job.setNumReduceTasks(2);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);
        FileInputFormat.addInputPath(job, new Path("/inputs/demo.txt"));
        FileOutputFormat.setOutputPath(job, new Path("/outputs/1111223"));
        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }
}