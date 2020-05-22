String queryExpression = "*:*";
 String sortField = "createTime";
-String baseUrl = SolrUtil.getSolrBaseURL(solrHttpServer.getBaseURL());
-solrHttpServer.setBaseURL(baseUrl + "/" + coreName);
 SolrQuery query = new SolrQuery();
 query.setQuery(queryExpression);
 query.setSortField(sortField, SolrQuery.ORDER.asc);
-QueryResponse rsp = solrHttpServer.query(query);
+QueryResponse rsp = servers.get(coreName).query(query);