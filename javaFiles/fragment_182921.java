Term term = new Term("title", "lucene");
TermQuery termQuery = new TermQuery(term);
SpanFirstQuery spanFirstQuery = new SpanFirstQuery(new SpanTermQuery(term), 1);
BooleanQuery booleanQuery = new BooleanQuery();
booleanQuery.add(new BooleanClause(termQuery, BooleanClause.Occur.MUST));
booleanQuery.add(new BooleanClause(spanFirstQuery, BooleanClause.Occur.SHOULD));