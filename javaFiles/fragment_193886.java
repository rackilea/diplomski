import java.io.IOException;
import java.util.ArrayList;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.Reducer.Context;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class SubStrings{

    public static class SubStringsMapper extends Mapper<Object, Text, IntWritable, Text> {

        @Override
        public void map(Object key, Text value, Context context) throws IOException, InterruptedException {

            String [] values = value.toString().split(" ");
            int len = Integer.parseInt(values[0].trim());
            String str = values[1].replaceAll("\"", "").trim();

            int endindex=len;
            for(int i = 0; i < len; i++)
            {
                endindex=i+len;
                if(endindex <= str.length())
                    context.write(new IntWritable(len), new Text(str.substring(i, endindex))); 
            }

        }   
    }

    public  static class SubStringsReducer extends Reducer<IntWritable, Text, IntWritable, Text> {

        public void reduce(IntWritable key, Iterable<Text> values, Context context) 
                throws IOException, InterruptedException {

            String str="\""; //adding starting quotes
            for(Text value: values)
                str += " " + value;

            str=str.replace("\" ", "\"") + "\""; //adding ending quotes
            context.write(key, new Text(str));
        }
    }

    public static void main(String[] args) throws Exception {

        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf, "get-possible-strings-by-length");

        job.setJarByClass(SubStrings.class);
        job.setMapperClass(SubStringsMapper.class); 
        job.setReducerClass(SubStringsReducer.class);

        job.setMapOutputKeyClass(IntWritable.class);
        job.setMapOutputValueClass(Text.class);

        job.setOutputKeyClass(IntWritable.class);
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