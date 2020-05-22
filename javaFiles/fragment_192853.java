BooleanQuery query = new BooleanQuery();

query.add(new TermQuery("attributeId", 10), BooleanClause.Occur.MUST); 
query.add(new TermQuery("value", "Romance"), BooleanClause.Occur.MUST); 

// build "IN" clause
BooleanQuery pidQuery = new BooleanQuery();
for( long productId : productIds ){
    pidQuery.add(new TermQuery("productId", productId), BooleanClause.Occur.SHOULD); 
}
query.add(pidQuery, BooleanClause.Occur.MUST); 
TopDocs docs = searcher.search(query, null, searchLimit);