private Text word = new Text();
private IntWritable count = new IntWritable(1);

public void map(LongWritable offset, Text line, Context context) {
  for (String s : line.toString().split(" ")) {
    word.set(s);
    context.write(word, count); // Text gets serialized here
  }
}