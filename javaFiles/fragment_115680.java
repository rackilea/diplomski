SearchRequestBuilder searchRequestBuilder = new SearchRequestBuilder(client);
searchRequestBuilder.setIndices("mongoindex");
searchRequestBuilder.setTypes("files");
QueryStringQueryBuilder queryStringQueryBuilder = new QueryStringQueryBuilder("anyword");
queryStringQueryBuilder.field("file.file");
searchRequestBuilder.setQuery(queryStringQueryBuilder);
SearchResponse response = searchRequestBuilder.execute().actionGet();