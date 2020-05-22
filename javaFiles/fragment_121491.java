public class DummyFileInputFormat extends FileInputFormat {
    public List<FileStatus> listStatus(Context mapContext) throws IOException {
        return super.listStatus(mapContext);
    }

    @Override
    public RecordReader createRecordReader(InputSplit split,
            TaskAttemptContext context) throws IOException,
            InterruptedException {
        // dummy input format, so this will never be called
        return null;
    }
}