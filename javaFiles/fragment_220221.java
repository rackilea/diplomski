public class ShuffleMapper extends Mapper<LongWritable, Text, Text, Text> {
  @Override
  protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
    context.write(new Text(UUID.randomUUID().toString()), value);
  }
}