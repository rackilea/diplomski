public class CustomScoreQuerySample {

public static void main(String[] args) throws Exception {
    CustomScoreQuerySample sample = new CustomScoreQuerySample();
    sample.makeIndex();
    sample.search("XX");
}

private static final String[][] DATAS = { { "XX", "981" }, { "XX", "672" },
        { "XX", "521" }, { "XX", "124" }, { "XX", "908" }, { "XX", "652" },
        { "XX", "872" }, { "XX", "278" }, { "XX", "485" }, { "XX", "372" } };

private RAMDirectory dir = new RAMDirectory();
private Analyzer analyzer = new SimpleAnalyzer(Version.LUCENE_44);

public void makeIndex() throws Exception {
    IndexWriterConfig config = new IndexWriterConfig(Version.LUCENE_44, analyzer);
    IndexWriter writer = new IndexWriter(dir, config);

    try {
        for (int i = 0; i < DATAS.length; i++) {
            Document doc = new Document();
            doc.add(new TextField("value", DATAS[i][0], Field.Store.YES ));
            doc.add(new FloatField("count", Float.parseFloat(DATAS[i][1]), Field.Store.YES ));
            writer.addDocument(doc);
        }
    } finally {
        writer.close();
    }
}
private void search(String value) throws Exception {

    DirectoryReader reader = DirectoryReader.open(dir);
    try {
        QueryParser parser = new QueryParser(Version.LUCENE_44, "value", analyzer);
        Query tq = parser.parse("XX");

        FloatFieldSource source = new FloatFieldSource("count");
        FunctionQuery fq = new FunctionQuery(source);

        CustomScoreQuery query = new CustomScoreQuery(tq, fq);

        TopScoreDocCollector collector = TopScoreDocCollector.create(5 * 5, false);

        IndexSearcher searcher = new IndexSearcher(reader);
        searcher.search(query,collector);

        ScoreDoc[] hits = collector.topDocs().scoreDocs;

        int count = hits.length;
        for (int i = 0; i < count; i++) {
            Document doc = searcher.doc(hits[i].doc);
            float score = hits[i].score;
            System.out.println(score + " : " + doc.get("value") + " / "
                    + doc.get("count"));
        }
    } finally {
        reader.close();
    }
}
}