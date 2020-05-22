public class AvgMapRed extends Configured implements Tool {

    public static final String APP_NAME = AvgMapRed.class.getSimpleName();

    public static void main(String[] args) throws Exception {
        final int status = ToolRunner.run(new Configuration(), new AvgMapRed(), args);
        System.exit(status);
    }

    @Override
    public int run(String[] args) throws Exception {
        Configuration conf = getConf();
        Job job = Job.getInstance(conf, APP_NAME);
        job.setJarByClass(AvgMapRed.class);

        job.setMapperClass(TokenizerMapper.class);
        job.setInputFormatClass(TextInputFormat.class);
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(Text.class);

        job.setReducerClass(AverageReducer.class);
        job.setOutputFormatClass(TextOutputFormat.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);

        FileInputFormat.addInputPath(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));

        return job.waitForCompletion(true) ? 0 : 1;
    }

    static class TokenizerMapper extends Mapper<LongWritable, Text, Text, Text> {

        private final Text word = new Text();
        private final Text segment = new Text();

        @Override
        protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

            String[] tokens = value.toString().split("\\|");

            if (tokens.length < 7) {
                System.err.printf("mapper: not enough records for %s", Arrays.toString(tokens));
                return;
            }
            String custKey = tokens[1];

            int nation = 0;
            float balance = 0;
            try {
                nation = Integer.parseInt(tokens[3]);
                balance = Float.parseFloat(tokens[5]);
            } catch (NumberFormatException e) {
                e.printStackTrace();
                return;
            }

            if (balance > 8000 && (nation < 15 && nation > 1)) {
                segment.set(tokens[6]);
                word.set(custKey + "\t" + balance);
                context.write(segment, word);
            }

        }
    }

    static class AverageReducer extends Reducer<Text, Text, Text, Text> {

        private final Text output = new Text();

        @Override
        protected void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {

            float sumBalance = 0;
            int count = 0;

            List<String> customers = new ArrayList<>();

            for (Text v : values) {
                String[] a = v.toString().trim().split("\t");

                customers.add(a[0]); // Count all customers for this key

                sumBalance += Float.parseFloat(a[1]);
                count++;
            }

            float avgBalance = count <= 1 ? sumBalance : (sumBalance / count);

            output.set(customers.size() + "\t" + avgBalance);
            context.write(key, output);
        }
    }
}