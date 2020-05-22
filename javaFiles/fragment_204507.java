private static class MyScoreQuery extends CustomScoreQuery {
    public MyScoreQuery(Query subQuery) {
        super(subQuery);
    }

    // The CustomScoreProvider is what actually alters the score
    private class MyScoreProvider extends CustomScoreProvider {

        private LeafReader reader;
        private Set<String> fieldsToLoad;

        public MyScoreProvider(LeafReaderContext context) {
            super(context);
            reader = context.reader();

            // We create a HashSet which contains the name of the field
            // which we need. This allows us to retrieve the document 
            // with only this field loaded, which is a lot faster.
            fieldsToLoad = new HashSet<>();
            fieldsToLoad.add("sum");
        }

        @Override
        public float customScore(int doc_id, float currentScore, float valSrcScore) throws IOException {
            // Get the result document from the index
            Document doc = reader.document(doc_id, fieldsToLoad);

            // Get boost value from index               
            IndexableField field = doc.getField("sum");
            Number number = field.numericValue();

            // This is just an example on how to alter the current score
            // based on the value of "sum". You will have to experiment
            // here.
            float influence = 0.01f;
            float boost = number.floatValue() * influence;

            // Return the new score for this result, based on the 
            // original lucene score.
            return currentScore + boost;
        }           
    }

    // Make sure that our CustomScoreProvider is being used.
    @Override
    public CustomScoreProvider getCustomScoreProvider(LeafReaderContext context) {
        return new MyScoreProvider(context);
    }       
}