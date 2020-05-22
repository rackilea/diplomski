public class CombineLzoLineRecordReader extends LzoLineRecordReader {
    private int index;
    **private static String currentPath**;

    public CombineLzoLineRecordReader(CombineFileSplit split, TaskAttemptContext context, Integer index)
        throws IOException, InterruptedException {
        this.index = index;
    }

    public void initialize(InputSplit genericSplit, TaskAttemptContext context) throws IOException, InterruptedException {
        CombineFileSplit combineSplit = (CombineFileSplit) genericSplit;
        FileSplit fileSplit = new FileSplit(combineSplit.getPath(index), combineSplit.getOffset(index), combineSplit.getLength(index), combineSplit.getLocations());
        **currentPath = fileSplit.getPath().toString();**
        super.initialize(fileSplit, context);
    }

    public static String getCurrentFilePath() {
        return currentFilePath;
    }
}