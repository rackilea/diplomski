public abstract class CustomComparator extends FieldComparator<Double> {
    double[] scoring;
    double bottom;
    double topValue;
    private FieldCache.Ints[] currentReaderValues;
    private String[] fields;

    protected abstract double getScore(int[] value);

    public CustomComparator(int hitNum, String[] fields) {
        this.fields = fields;
        scoring = new double[hitNum];
    }

    int[] fromReaders(int doc) {
        int[] result = new int[currentReaderValues.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = currentReaderValues[i].get(doc);
        }
        return result;
    }

    @Override
    public int compare(int slot1, int slot2) {
        return Double.compare(scoring[slot1], scoring[slot2]);
    }

    @Override
    public void setBottom(int slot) {
        this.bottom = scoring[slot];
    }

    @Override
    public void setTopValue(Double top) {
        topValue = top;
    }

    @Override
    public int compareBottom(int doc) throws IOException {
        double v2 = getScore(fromReaders(doc));
        return Double.compare(bottom, v2);
    }

    @Override
    public int compareTop(int doc) throws IOException {
        double docValue = getScore(fromReaders(doc));
        return Double.compare(topValue, docValue);
    }

    @Override
    public void copy(int slot, int doc) throws IOException {
        scoring[slot] = getScore(fromReaders(doc));
    }

    @Override
    public FieldComparator<Double> setNextReader(AtomicReaderContext atomicReaderContext) throws IOException {
        currentReaderValues = new FieldCache.Ints[fields.length];
        for (int i = 0; i < fields.length; i++) {
            currentReaderValues[i] = FieldCache.DEFAULT.getInts(atomicReaderContext.reader(), fields[i], null, false);
        }
        return this;
    }

    @Override
    public Double value(int slot) {
        return scoring[slot];
    }
}