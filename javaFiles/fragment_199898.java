TermsBuilder termBuilder = AggregationBuilders.terms("check_id");
MaxBuilder maxBuilder = AggregationBuilders.max("exec_time_epoch");
MinBuilder minBuilder = AggregationBuilders.min("exec_time_epoch");

termBuilder.subAggregation(maxBuilder);
termBuilder.subAggregation(minBuilder);

// ADD THIS: add another top_hits sub-aggregation which
// - takes a single document
// - sorted by exec_time_epoch desc
TopHitsBuilder topHitsBuilder = AggregationBuilders.topHits("maxDoc")
    .setSize(1)
    .addSort("exec_time_epoch", SortOrder.DESC);
termBuilder.subAggregation(topHitsBuilder);

SearchQuery searchQuery = new NativeSearchQueryBuilder()
    .withQuery(matchAllQuery())
    .addAggregation(termBuilder)
    .build();

Aggregations aggregations = elasticsearchTemplate.query(searchQuery, new ResultsExtractor<Aggregations>() {
    @Override
    public Aggregations extract(SearchResponse response) {
        return response.getAggregations();
    }
});