public class SortExample {

    public static void main(String[] args) throws IOException {

        final String[] fields = new String[]{"descriptionLength", "views.views", "nameLength"};

        Sort sort = new Sort(
                new SortField(
                        "",
                        new FieldComparatorSource() {
                            public FieldComparator newComparator(String fieldname, int numHits, int sortPos, boolean reversed) throws IOException {
                                return new CustomComparator(numHits, fields) {
                                    @Override
                                    protected double getScore(int[] value) {
                                        int descriptionLength = value[0];
                                        int views = value[1];
                                        int nameLength = value[2];
                                        return -((descriptionLength > 2000.0 ? 5.0 : 0.0) +
                                                (views > 5000.0 ? 3.0 : 0.0) +
                                                (nameLength > 20.0 ? 1.0 : 0.0));
                                    }
                                };
                            }
                        }
                )
        );

        IndexWriterConfig indexWriterConfig = new IndexWriterConfig(Version.LUCENE_4_10_4, new StandardAnalyzer());
        Directory directory = new RAMDirectory();
        IndexWriter indexWriter = new IndexWriter(directory, indexWriterConfig);

        addDoc(indexWriter, "score 0", 1000, 1000, 10);
        addDoc(indexWriter, "score 5", 3000, 1000, 10);
        addDoc(indexWriter, "score 3", 1000, 6000, 10);
        addDoc(indexWriter, "score 1", 1000, 1000, 30);
        addDoc(indexWriter, "score 4", 1000, 6000, 30);
        addDoc(indexWriter, "score 6", 5000, 1000, 30);
        addDoc(indexWriter, "score 9", 5000, 6000, 30);

        final IndexReader indexReader = DirectoryReader.open(indexWriter, false);
        IndexSearcher indexSearcher = new IndexSearcher(indexReader);
        Query query = new TermQuery(new Term("all", "all"));
        int nDocs = 100;

        final TopDocs search = indexSearcher.search(query, null, nDocs, sort);
        System.out.println("Max " + search.scoreDocs.length + " " + search.getMaxScore());
        for (ScoreDoc sd : search.scoreDocs) {
            Document document = indexReader.document(sd.doc);
            System.out.println(document.getField("name").stringValue());
        }

    }

    private static void addDoc(IndexWriter indexWriter, String name, int descriptionLength, int views, int nameLength) throws IOException {
        Document doc = new Document();
        doc.add(new TextField("name", name, Field.Store.YES));
        doc.add(new TextField("all", "all", Field.Store.YES));
        doc.add(new IntField("descriptionLength", descriptionLength, Field.Store.YES));
        doc.add(new IntField("views.views", views, Field.Store.YES));
        doc.add(new IntField("nameLength", nameLength, Field.Store.YES));
        indexWriter.addDocument(doc);
    }
}