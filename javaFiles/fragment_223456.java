public class MyMapper extends Mapper<LongWritable, Text, IntWritable, Text> {
    private IntWritable mapId;

    @Override
    protected void setup(Context context) throws IOException,
            InterruptedException {
        mapId = new IntWritable(context.getTaskAttemptID().getTaskID().getId());
    }

    @Override
    protected void map(LongWritable key, Text value, Context context)
            throws IOException, InterruptedException {
        // ...

        context.write(mapId, value);
    }
}