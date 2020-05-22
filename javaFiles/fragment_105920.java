IndexSearcher searcher = new IndexSearcher("path_to_index");
MatchAllDocsQuery everyDocClause = new MatchAllDocsQuery();
TermQuery termClause = new TermQuery(new Term("text", "exclude_term"));
BooleanQuery query = new BooleanQuery();
query.add(everyDocClause, BooleanClause.Occur.MUST);
query.add(termClause, BooleanClause.Occur.MUST_NOT);
Hits hits = searcher.search(query);