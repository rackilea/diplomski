public class AerospikeOutputFormat extends OutputFormat {
    //Return a new instance of record writer
    @Override
    public RecordWriter getRecordWriter(TaskAttemptContext context) throws IOException, InterruptedException {
        return new AerospikeRecordWriter(context.getConfiguration(), new Progressable() {
        @Override
        public void progress() {

        }
    });
    }

}