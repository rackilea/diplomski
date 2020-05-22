public class JoinMapperName extends Mapper<LongWritable, Text, Text, Text> {
    public void map(LongWritable k, Text value, Context context) 
                          throws IOException, InterruptedException {

        String[] words = value.toString().split(",");
        context.write(new Text(words[0]), new Text("name:" + words[1]));
    }
}

public class JoinMapperDept extends Mapper<LongWritable, Text, Text, Text> {
    public void map(LongWritable k, Text value, Context context) 
                          throws IOException, InterruptedException {

        String[] words = value.toString().split(",");
        context.write(new Text(words[0]), new Text("dept:" + words[1]));
    }
}