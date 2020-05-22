public class JoinReducer extends Reducer<Text, Text, NullWritable, Text> {
    public void reduce(Text key, Iterable<Text> values, Context context) 
              throws IOException, InterruptedException {

        String name = "";
        String dept = "";
        for(Text value : values) {
            if (value.toString().startsWith("name")) {
                name = value.toString().split(":")[1];
            } else {
                dept = value.toString().split(":")[1];
            }
        }
        String merge = key + "," name + "," + dept;
        context.write(NullWritable.get(), new Text(merge));
    }
}