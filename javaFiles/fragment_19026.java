public class MaxTemperatureReducer extends Reducer<IntWritable, DoubleWritable, IntWritable, DoubleWritable> {
    private static int year = 0;
    private static double maxTemp = 0.0;

    @Override
    public void reduce(IntWritable key, Iterable<DoubleWritable> values, Context context) throws IOException, InterruptedException {
        for (DoubleWritable value : values) {
            if (value.get() > maxTemp) {
                year = key.get();
                maxTemp = value.get();
            }
        }
    }

    @Override
    public void cleanup(Context context) throws IOException, InterruptedException {
        context.write(new IntWritable(year), new DoubleWritable(maxTemp));
    }
}