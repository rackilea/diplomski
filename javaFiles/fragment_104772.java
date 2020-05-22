org.apache.lucene.search.Query query1 = ....;
org.apache.lucene.search.Query query2 = ....;
org.apache.lucene.search.Query query3 = ....;

BooleanQuery booleanQuery = new BooleanQuery();

luceneBooleanQuery.add(query1, BooleanClause.Occur.MUST);
luceneBooleanQuery.add(query2, BooleanClause.Occur.SHOULD);
luceneBooleanQuery.add(query3, BooleanClause.Occur.SHOULD); 

FullTextQuery fullTextQuery = fullTextSession.createFullTextQuery(booleanQuery, DomainClass.class);