@Override
public YYY findBy(XXX xxx) {
  Client client = template.getClient();
  MultiSearchRequest request = new MultiSearchRequest();
  // build searchQuery like normal
  for (NativeSearchQuery searchQuery : queries) {
    request.add(prepareSearch(client, searchQuery));
  }
  ActionFuture<MultiSearchResponse> future = client
      .multiSearch(request);
  MultiSearchResponse response = future.actionGet();
  Item[] items = response.getResponses();
  for (int i = 0; i < items.length; i++) {
    AggregatedPage<XXX> ts = resultMapper.mapResults(items[i].getResponse(), XXX.class, page);
    // do with page
  }
}

private SearchRequestBuilder prepareSearch(Client client, SearchQuery searchQuery) {
  Assert.notNull(searchQuery.getIndices(), "No index defined for Query");
  Assert.notNull(searchQuery.getTypes(), "No type defined for Query");

  int startRecord = 0;
  SearchRequestBuilder searchRequest = client.prepareSearch(toArray(searchQuery.getIndices()))
      .setSearchType(searchQuery.getSearchType()).setTypes(toArray(searchQuery.getTypes()));

  if (searchQuery.getSourceFilter() != null) {
    SourceFilter sourceFilter = searchQuery.getSourceFilter();
    searchRequest.setFetchSource(sourceFilter.getIncludes(), sourceFilter.getExcludes());
  }

  if (searchQuery.getPageable().isPaged()) {
    startRecord = searchQuery.getPageable().getPageNumber() * searchQuery.getPageable().getPageSize();
    searchRequest.setSize(searchQuery.getPageable().getPageSize());
  }
  searchRequest.setFrom(startRecord);

  if (!searchQuery.getFields().isEmpty()) {
    searchRequest.setFetchSource(toArray(searchQuery.getFields()), null);
  }

  if (searchQuery.getSort() != null) {
    for (Sort.Order order : searchQuery.getSort()) {
      searchRequest.addSort(order.getProperty(),
          order.getDirection() == Sort.Direction.DESC ? SortOrder.DESC : SortOrder.ASC);
    }
  }

  if (searchQuery.getMinScore() > 0) {
    searchRequest.setMinScore(searchQuery.getMinScore());
  }

  if (searchQuery.getFilter() != null) {
    searchRequest.setPostFilter(searchQuery.getFilter());
  }

  if (!isEmpty(searchQuery.getElasticsearchSorts())) {
    for (SortBuilder sort : searchQuery.getElasticsearchSorts()) {
      searchRequest.addSort(sort);
    }
  }

  if (!searchQuery.getScriptFields().isEmpty()) {
    //_source should be return all the time
    //searchRequest.addStoredField("_source");
    for (ScriptField scriptedField : searchQuery.getScriptFields()) {
      searchRequest.addScriptField(scriptedField.fieldName(), scriptedField.script());
    }
  }

  if (searchQuery.getHighlightFields() != null) {
    for (HighlightBuilder.Field highlightField : searchQuery.getHighlightFields()) {
      searchRequest.highlighter(new HighlightBuilder().field(highlightField));
    }
  }

  if (!isEmpty(searchQuery.getIndicesBoost())) {
    for (IndexBoost indexBoost : searchQuery.getIndicesBoost()) {
      searchRequest.addIndexBoost(indexBoost.getIndexName(), indexBoost.getBoost());
    }
  }

  if (!isEmpty(searchQuery.getAggregations())) {
    for (AbstractAggregationBuilder aggregationBuilder : searchQuery.getAggregations()) {
      searchRequest.addAggregation(aggregationBuilder);
    }
  }

  if (!isEmpty(searchQuery.getFacets())) {
    for (FacetRequest aggregatedFacet : searchQuery.getFacets()) {
      searchRequest.addAggregation(aggregatedFacet.getFacet());
    }
  }

  return searchRequest.setQuery(searchQuery.getQuery());
}