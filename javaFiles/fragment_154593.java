// 1. bootstrap the query
SearchRequestBuilder search = node.client().prepareSearch()
    .setSize(0).setFrom(0)
    .setQuery(QueryBuilders.queryStringQuery("myfield:*"));

// 2. create the filter aggregations
FilterAggregationBuilder lowAgg = AggregationBuilders
    .filter("foo_low")
    .filter(QueryBuilders.queryStringQuery("myfield:[1 TO 5]"));
search.addAggregation(lowAgg);
FilterAggregationBuilder highAgg = AggregationBuilders
    .filter("foo_high")
    .filter(QueryBuilders.queryStringQuery("myfield:[6 TO 10]"));
search.addAggregation(highAgg);

// 3. execute the query
SearchResponse response = search.execute().actionGet();