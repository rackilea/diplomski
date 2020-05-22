BooleanQuery query = new BooleanQuery();
    Query origSearch = getOrigSearch(searchString);
    Query refinement = makeRefinement();
    query.add(origSearch, Occur.MUST);
    query.add(refinement, Occur.MUST);
    TopDocs topDocs = searcher.search(query, maxHits);