// create the fruit color facet
TermFacetRequest fruitColor = new TermFacetRequest("fruit_color");
fruitColor.setFields("fruit_color");
fruitColor.setSize(5);

// create the fruit weight facet
TermFacetRequest fruitWeight = new TermFacetRequest("fruit_weight");
fruitWeight.setFields("fruit_weight");
fruitWeight.setSize(5);

SearchQuery searchQuery = new NativeSearchQueryBuilder()
    .withPageable(new PageRequest(0, 10))
    .withQuery(QueryBuilders.queryStringQuery("Banana AND (start:>=1492274000000) AND (end:<=1386842400000)"))                
    .withSort(SortBuilders.fieldSort("fruitId").order(SortOrder.DESC))                
    .withIndices("fruit").withTypes("fruit")
    .withFacet(fruitColor)            <--- add the fruit color facet
    .withFacet(fruitWeight);          <--- add the fruit weight facet