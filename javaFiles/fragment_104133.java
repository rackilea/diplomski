BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
boolQueryBuilder
    .filter(QueryBuilders.termQuery("user", "kimchy"))
    .filter(QueryBuilders.termQuery("city", "london"));
SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
sourceBuilder.query(boolQueryBuilder);