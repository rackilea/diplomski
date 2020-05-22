Directory directory = new RAMDirectory();
Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_30);
MaxFieldLength mlf = MaxFieldLength.UNLIMITED;
IndexWriter writer = new IndexWriter(directory, analyzer, true, mlf);

Document doc = new Document();
doc.add(new Field("tags", "foo bar", Field.Store.NO,
        Field.Index.ANALYZED, Field.TermVector.YES));

writer.addDocument(doc);
writer.close();

IndexReader reader = IndexReader.open(directory);
for (int i = 0; i < reader.numDocs(); i++) {
    TermFreqVector tfv = reader.getTermFreqVector(i, "tags");
    System.out.println(tfv);
}