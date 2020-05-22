TermQuery tq= new TermQuery(new Term("url", url));
// BooleanClauses Enum SHOULD says Use this operator for clauses that should appear in the matching documents.
BooleanQuery bq = new BooleanQuery().add(tq,BooleanClause.Occur.SHOULD);
IndexSearcher searcher = new IndexSearcher(index, true);
TopScoreDocCollector collector = TopScoreDocCollector.create(10, true);
searcher.search(query, collector);