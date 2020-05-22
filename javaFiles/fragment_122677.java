public class PDFInputFormat extends FileInputFormat<Text, Text> {

  @Override
  public RecordReader<Text, Text> createRecordReader(InputSplit split,
    TaskAttemptContext context) throws IOException, InterruptedException {
      return new PDFLineRecordReader();
  }

  // Do not allow to ever split PDF files, even if larger than HDFS block size
  @Override
  protected boolean isSplitable(JobContext context, Path filename) {
    return false;
  }

}