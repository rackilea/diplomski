final String[] fields = new String[]{ "field1", "field2", "field3" };
final float[] scalars = new float[]{ 0.5f, 1.4f, 1.8f };

Sort sort = new Sort(
    new SortField(
        "",
        new SortComparatorSource() {
            public ScoreDocComparator newComparator(IndexReader reader, String fieldName) throws IOException {
                return new ScaledScoreDocComparator(reader, fields, scalars);
            }
        }
    )
);

IndexSearcher indexSearcher = ...;
Query query = ...;
Filter filter = ...; // can be null
int nDocs = 100;

TopFieldDocs topFieldDocs = indexSearcher.search(query, filter, nDocs, sort);
ScoreDoc[] scoreDocs = topFieldDocs.scoreDocs;