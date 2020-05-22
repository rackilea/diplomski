public static class KVMapper 
    extends Mapper<Text, Text, Text, LongWritable>{
    private final static LongWritable val = new LongWritable();
    public void map(Text key, Text value, Context context) {
      val.set(Long.parseLong(value.toString()));
      context.write(key,val);
    }
}