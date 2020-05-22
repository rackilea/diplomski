public void insertOneDoc() throws SolrServerException, IOException {
  HttpSolrServer solr = new HttpSolrServer(solrIndexPath);
  SolrInputDocument doc = new SolrInputDocument();
  doc.addField("fieldName", "fieldValue");
  solr.add(doc);
  solr.commit();
}