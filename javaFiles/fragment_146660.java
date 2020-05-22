// Your user query, which contains both Occur.SHOULD and Occur.MUST clauses
BooleanQuery userQuery = createUserQuery();

// Your filter query, could be a BooleanQuery on its own
Query filterQuery = getFilterQuery();

BooleanQuery finalQuery = new BooleanQuery();
finalQuery.add(userQuery, Occur.MUST);
finalQuery.add(filterQuery, Occur.FILTER);
// Search using the finalQuery
TopDocs docs = mySearcher.search(finalQuery, maxdocs, sort);