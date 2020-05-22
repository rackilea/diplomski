public static class IntSumReducer extends
        Reducer<Text, Text, Text, IntWritable> {
    private IntWritable result = new IntWritable();
    public void reduce(Text key, Iterable<Text> values,
            Context context) throws IOException, InterruptedException {
        HashSet<Text> set = new HashSet<Text>();
          int sum = 0;
          for (Text val : values) {
                if(!set.contains(val)){
                    set.add(val);
                    sum++;
                }
          }   

          result.set(sum);
          context.write(key, result);

    }
}