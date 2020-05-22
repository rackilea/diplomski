CoreDescriptor coreDescriptor = rb.req.getCore().getCoreDescriptor();
String collectionName = coreDescriptor.getCloudDescriptor().getCollectionName();    
ZkController zkController = coreDescriptor.getCoreContainer().getZkController();    
String zookeeperUrl = zkController.getZkServerAddress();

CloudSolrServer server = new CloudSolrServer(zookeeperUrl);
server.setDefaultCollection(collectionName);
server.connect();

SolrRequest request = ... //initialize the solr request to execute the query
NamedList<Object> solrResponse = server.request(solrRequest);
// do whatever you like with the returned response;
server.shutdown();