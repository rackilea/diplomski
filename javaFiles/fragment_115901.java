public class PreprocessRecordProcessor<T extends Record> extends RecordProcessor<T> {
    // ...
    public void process() {
        preProcess();
        super.process();
    }

    protected abstract void preProcess();
}