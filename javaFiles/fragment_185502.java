String urlString = "http://localhost:8983/solr/jcg";
SolrClient client = new HttpSolrClient(urlString);
SolrInputDocument doc1 = new SolrInputDocument();
doc1.addField( "id", "new-document-id" );
Collection<SolrInputDocument> docs = new ArrayList<SolrInputDocument>();
docs.add( doc1 );
client.add( docs );
client.commit();
client.close();