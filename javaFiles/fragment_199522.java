public class ScaledComparator extends FieldComparator {

    private String[] fields;
    private float[] scalars;
    private int[][] slotValues;
    private int[][] currentReaderValues;
    private int bottomSlot;

    public ScaledComparator(int numHits, String[] fields, float[] scalars) {
        this.fields = fields;
        this.scalars = scalars;

        this.slotValues = new int[this.fields.length][];
        for (int fieldIndex = 0; fieldIndex < this.fields.length; fieldIndex++) {
            this.slotValues[fieldIndex] = new int[numHits];
        }

        this.currentReaderValues = new int[this.fields.length][];
    }

    protected float score(int[][] values, int secondaryIndex) {
        float score = 0;

        for (int fieldIndex = 0; fieldIndex < fields.length; fieldIndex++) {
            int value = values[fieldIndex][secondaryIndex];
            float scalar = scalars[fieldIndex];
            score += (value * scalar);
        }

        return score;
    }

    protected float scoreSlot(int slot) {
        return score(slotValues, slot);
    }

    protected float scoreDoc(int doc) {
        return score(currentReaderValues, doc);
    }

    @Override
    public int compare(int slot1, int slot2) {
        float score1 = scoreSlot(slot1);
        float score2 = scoreSlot(slot2);
        return Float.compare(score1, score2);
    }

    @Override
    public int compareBottom(int doc) throws IOException {
        float bottomScore = scoreSlot(bottomSlot);
        float docScore = scoreDoc(doc);
        return Float.compare(bottomScore, docScore);
    }

    @Override
    public void copy(int slot, int doc) throws IOException {
        for (int fieldIndex = 0; fieldIndex < fields.length; fieldIndex++) {
            slotValues[fieldIndex][slot] = currentReaderValues[fieldIndex][doc];
        }
    }

    @Override
    public void setBottom(int slot) {
        bottomSlot = slot;
    }

    @Override
    public void setNextReader(IndexReader reader, int docBase, int numSlotsFull) throws IOException {
        for (int fieldIndex = 0; fieldIndex < fields.length; fieldIndex++) {
            String field = fields[fieldIndex];
            currentReaderValues[fieldIndex] = FieldCache.DEFAULT.getInts(reader, field);
        }
    }

    @Override
    public int sortType() {
        return SortField.CUSTOM;
    }

    @Override
    public Comparable<?> value(int slot) {
        float score = scoreSlot(slot);
        return Float.valueOf(score);
    }

}