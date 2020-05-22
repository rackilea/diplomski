int numberOfHits = 200;
String LocationOfDirectory = "C:\\dir\\index";
TopScoreDocCollector collector = TopScoreDocCollector.create(numberOfHits, true);
Directory directory = new SimpleFSDirectory(new File(LocationOfDirectory));
IndexSearcher searcher = new IndexSearcher(IndexReader.open(directory);

StandardAnalyzer analyzer = new StandardAnalyzer(Version.LUCENE_35);

//WildcardQuery q = new WildcardQuery(new Term("Street", "the crescent");
QueryParser qp = new QueryParser(Version.LUCENE_35, "Street", analyzer);
qp.setDefaultOperator(QueryParser.Operator.AND);

Query q = qp.parse("grove road");

searcher.search(q, collector);
ScoreDoc[] hits = collector.topDocs().scoreDocs;