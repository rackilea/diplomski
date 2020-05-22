public class ScaledScoreDocComparator implements ScoreDocComparator {

    private int[][] values;
    private float[] scalars;

    public ScaledScoreDocComparator(IndexReader reader, String[] fields, float[] scalars) throws IOException {
        this.scalars = scalars;
        this.values = new int[fields.length][];
        for (int i = 0; i < values.length; i++) {
            this.values[i] = FieldCache.DEFAULT.getInts(reader, fields[i]);
        }
    }

    protected float score(ScoreDoc scoreDoc) {
        int doc = scoreDoc.doc;

        float score = 0;
        for (int i = 0; i < values.length; i++) {
            int value = values[i][doc];
            float scalar = scalars[i];
            score += (value * scalar);
        }
        return score;
    }

    @Override
    public int compare(ScoreDoc i, ScoreDoc j) {
        float iScore = score(i);
        float jScore = score(j);
        return Float.compare(iScore, jScore);
    }

    @Override
    public int sortType() {
        return SortField.CUSTOM;
    }

    @Override
    public Comparable<?> sortValue(ScoreDoc i) {
        float score = score(i);
        return Float.valueOf(score);
    }

}