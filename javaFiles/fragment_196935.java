@Override
 public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

     String[] keyValue = value.toString().split("-");
     // would emit John -> 23 as a text
     context.write(new Text(keyValue[0]), new Text(keyValue[1]));
 }