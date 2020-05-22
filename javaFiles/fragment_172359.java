public class WordCount {

   public static class TokenizerMapper
        extends Mapper<Object, Text, Text, IntWritable>{

     private final static IntWritable one = new IntWritable(1);
     private Text word = new Text();

     public void map(Object key, Text value, Context context
                ) throws IOException, InterruptedException {
         String data = value.toString();
         for (int i = 0; i < (data.length() / 3) - 1; i++) {
             String pair = data.substring(i*3, (i*3)+5);
             context.write(new Text(pair), one);
         }
      }
   }