public class MergingItemReader implements ItemStreamReader<MergedRecord> {

    private ItemStreamReader<RecordTypeA> readerA;
    private ItemStreamReader<RecordTypeB> readerB;

    @Override
    public MergedRecord read() throws Exception {
        RecordTypeA itemA = readerA.read();
        RecordTypeB itemB = readerB.read();
        Assert.isTrue(itemA.getKey().equals(itemB.getKey()), "Inconsistent data");
        return new MergedRecord(itemA, itemB);
    }

    @Override
    public void open(ExecutionContext executionContext) throws ItemStreamException {
        readerA.open(executionContext);
        readerB.open(executionContext);
    }

    @Override
    public void update(ExecutionContext executionContext) throws ItemStreamException {
        readerA.update(executionContext);
        readerB.update(executionContext);
    }

    @Override
    public void close() throws ItemStreamException {
        readerA.close();
        readerB.close();
    }

    public void setReaderA(ItemStreamReader<RecordTypeA> readerA) {
        this.readerA = readerA;
    }

    public void setReaderB(ItemStreamReader<RecordTypeB> readerB) {
        this.readerB = readerB;
    }

}