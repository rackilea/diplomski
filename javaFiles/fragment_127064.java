Directory dir = new RAMDirectory();
Analyzer analyzer = null;
IndexWriterConfig iwc = new IndexWriterConfig(Version.LUCENE_4_10_1, analyzer);
IndexWriter indexWriter = new IndexWriter(dir, iwc);

Document doc1 = new Document();
doc1.add(new StringField("title", "aa", Field.Store.YES));
indexWriter.addDocument(doc1);
indexWriter.commit();

IndexReader reader = IndexReader.open(dir);
IndexSearcher searcher = new IndexSearcher(reader);
// print results using MatchAllDocsQuery