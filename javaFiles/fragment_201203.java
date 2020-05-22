public class DataApp{

    public static class DataMapper extends Mapper<Object, Text, NullWritable, Text> {
        public void map(Object key, Text value, Context context) throws IOException, InterruptedException{
            System.out.println("(hi, " + value.getLength() + ")");
            context.write(NullWritable.get(), new Text("(hi, " + value.getLength() + ")"));
        }   
    }

    public  static class DataReducer extends Reducer<NullWritable, Text, NullWritable, Text> {    
        public void reduce(NullWritable key, Iterable<Text> values, Context context) 
                throws IOException, InterruptedException {
            String str="";
            for(Text value: values){
                str += value.toString() + " ";
            }
            context.write(NullWritable.get(), new Text(str));
        }
    }

    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf, "stackoverflow-41476232");

        job.setJarByClass(DataApp.class);
        job.setMapperClass(DataMapper.class);
        job.setReducerClass(DataReducer.class);
        job.setMapOutputKeyClass(NullWritable.class);
        job.setMapOutputValueClass(Text.class);
        job.setOutputKeyClass(NullWritable.class);
        job.setOutputValueClass(Text.class);

        FileInputFormat.addInputPath(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));
        FileSystem fs = null;
        Path dstFilePath = new Path(args[1]);
        try {
            fs = dstFilePath.getFileSystem(conf);
            if (fs.exists(dstFilePath))
                fs.delete(dstFilePath, true);
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        job.waitForCompletion(true);
    } 
}