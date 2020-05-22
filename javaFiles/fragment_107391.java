Date dateFrom = new Date(System.currentTimeMillis() - 300 * 1000);
Date dateTo = new Date(System.currentTimeMillis());

BoolQueryBuilder query = QueryBuilders.boolQuery()
    .must(QueryBuilders.rangeQuery("@timestamp").from(dateFrom).to(dateTo))
    .must(QueryBuilders.matchQuery("tags", "kpi"));

SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
searchSourceBuilder.query(query);
SearchRequest searchRequest = new SearchRequest();
searchRequest.source(searchSourceBuilder);
System.out.println(query.toString());
SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);

logger.log(Level.INFO, "Status: {0}", new Object[] { searchResponse.status() });
logger.log(Level.INFO, "Took: {0}", new Object[] { searchResponse.getTook() });
logger.log(Level.INFO, "IsTerminatedEarly: {0}", new Object[] { searchResponse.isTerminatedEarly() });
logger.log(Level.INFO, "TimedOut: {0}", new Object[] { searchResponse.isTimedOut() });
logger.log(Level.INFO, "TotalShards: {0}", new Object[] { searchResponse.getTotalShards() });
logger.log(Level.INFO, "SuccessfulShards: {0}", new Object[] { searchResponse.getSuccessfulShards() });
logger.log(Level.INFO, "FailedShards: {0}", new Object[] { searchResponse.getFailedShards() });
logger.log(Level.INFO, "Total Hits: {0}", new Object[] { searchResponse.getHits().getTotalHits() });