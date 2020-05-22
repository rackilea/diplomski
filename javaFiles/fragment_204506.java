Query q = .....

// Note that a Float field would work better.
DoubleValuesSource boostByField = DoubleValuesSource.fromLongField("sum");

// Create a query, based on the old query and the boost
FunctionScoreQuery modifiedQuery = new FunctionScoreQuery(q, boostByField);

// Search as usual
TopDocs hits = searcher.search(query, 10);