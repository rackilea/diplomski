// 1. bootstrap the query
SearchRequestBuilder search = node.client().prepareSearch()
    .setSize(0).setFrom(0)
    .setQuery(QueryBuilders.queryStringQuery("myfield:*"));

// 2. create the range aggregation
RangeBuilder rangeAgg = AggregationBuilders.range("high_low").field("myfield");
rangeAgg.addRange("foo_low", 1, 6);
rangeAgg.addRange("foo_high", 6, 11);
search.addAggregation(rangeAgg);

// 3. execute the query
SearchResponse response = search.execute().actionGet();