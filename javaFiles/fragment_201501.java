CommonsHttpSolrServer commonsHttpSolrServer = new CommonsHttpSolrServer("solr_path_url");
commonsHttpSolrServer.setParser(new XMLResponseParser());
ModifiableSolrParams params = new ModifiableSolrParams();
// Specify the Request handler
params.add("qt", "dismax_request_handler");
params.add("q", "query_string");
QueryResponse response = commonsHttpSolrServer.query(params);