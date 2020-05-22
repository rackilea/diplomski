public class MyJob extends Configured implements Tool
{
   public void run(String[] args) throws Exception {
     // ...
     TextInputFormat.setInputPaths(job, new Path(args[0])); // or some other file input format
     TextOutputFormat.setOutputPath(job, new Path(args[1]));
   }
}