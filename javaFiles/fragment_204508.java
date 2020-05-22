Query q = .....

// Create a query, based on the old query and the boost
MyScoreQuery modifiedQuery = new MyScoreQuery(q);

// Search as usual
TopDocs hits = searcher.search(query, 10);