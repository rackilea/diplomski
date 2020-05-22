QueryBuilder matchFirst = QueryBuilders.boolQuery()
        .must(QueryBuilders.matchQuery("authorList.authorOrder", 1));
QueryBuilder mainQuery = QueryBuilders.nestedQuery("authorList", matchFirst, ScoreMode.None);

SortBuilder sb = SortBuilders.fieldSort("authorList.lastName")
    .order(SortOrder.ASC)
    .setNestedPath("authorList")
    .setNestedFilter(matchFirst);

SearchRequestBuilder builder = client.prepareSearch("test")
        .setSize(50)
        .setQuery(mainQuery)
        .addSort(sb);