public class InputFormat extends  FileInputFormat {    
 public
 RecordReader<NullWritable, ArrayList<Record>> 
  createRecordReader(InputSplit split, TaskAttemptContext context)
 throws IOException, InterruptedException{  //Logic Goes here  }

      @Override
          protected boolean isSplitable(JobContext context, Path file) {             return false;     
} 
}