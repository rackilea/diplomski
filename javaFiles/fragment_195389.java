// get a IndexSearcher for searching
IndexSearcher searcher = searcherManager.aquire();

// release IndexSearcher after search
searcherManager.release(searcher);

// refresh and add new index records to next search. usually after a commit 
searcherManager.maybeRefresh();