ModifiableSolrParams queryParamMap= new ModifiableSolrParams();
queryParamMap.set("q", "test");
queryParamMap.set("defType", "edismax");
queryParamMap.set("qf", "a b c d");
QueryResponse qResp = cloudSolrClient.query(queryParamMap);
SolrDocumentList docList = qResp.getResults();
int numFound = (int) docList.getNumFound();