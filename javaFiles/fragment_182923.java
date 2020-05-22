public static void main(String[] args) throws Exception {

        Directory directory = FSDirectory.open(new File("data"));

        index(directory);

        IndexReader indexReader = DirectoryReader.open(directory);
        IndexSearcher indexSearcher = new IndexSearcher(indexReader);

        Term term = new Term("title", "lucene");

        System.out.println("------ TermQuery --------");
        TermQuery termQuery = new TermQuery(term);
        search(indexSearcher, termQuery);

        System.out.println("------ SpanFirstQuery --------");
        SpanFirstQuery spanFirstQuery = new SpanFirstQuery(new SpanTermQuery(term), 1);
        search(indexSearcher, spanFirstQuery);

        System.out.println("------ BooleanQuery: TermQuery (MUST) + SpanFirstQuery (SHOULD) --------");
        BooleanQuery booleanQuery = new BooleanQuery();
        booleanQuery.add(new BooleanClause(termQuery, BooleanClause.Occur.MUST));
        booleanQuery.add(new BooleanClause(spanFirstQuery, BooleanClause.Occur.SHOULD));
        search(indexSearcher, booleanQuery);
    }

    private static void index(Directory directory) throws Exception {
        IndexWriterConfig config = new IndexWriterConfig(Version.LUCENE_41, new StandardAnalyzer(Version.LUCENE_41));

        IndexWriter writer = new IndexWriter(directory, config);

        FieldType titleFieldType = new FieldType();
        titleFieldType.setIndexOptions(FieldInfo.IndexOptions.DOCS_AND_FREQS_AND_POSITIONS);
        titleFieldType.setIndexed(true);
        titleFieldType.setStored(true);

        Document document = new Document();
        document.add(new Field("title","I have a question about lucene", titleFieldType));
        writer.addDocument(document);

        document = new Document();
        document.add(new Field("title","Lucene: I have a really hard question about it", titleFieldType));
        writer.addDocument(document);

        writer.close();
    }

    private static void search(IndexSearcher indexSearcher, Query query) throws Exception {
        TopDocs topDocs = indexSearcher.search(query, 10);

        System.out.println("Total hits: " + topDocs.totalHits);

        for (ScoreDoc hit : topDocs.scoreDocs) {
            Document result = indexSearcher.doc(hit.doc);
            for (IndexableField field : result) {
                System.out.println(field.name() + ": " + field.stringValue() +  " - score: " + hit.score);
            }
        }
    }