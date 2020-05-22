FilteredQueryBuilder queryBuilder = 
        new FilteredQueryBuilder(
                QueryBuilders.matchAllQuery(),
                FilterBuilders.rangeFilter("datefield").lte("now")
        );
SearchSourceBuilder query = SearchSourceBuilder.searchSource().query(queryBuilder);

client.prepareMoreLikeThis("index","type","id")
    .setField("field1","field2")
    .setSearchSource(query)
    .execute().actionGet();