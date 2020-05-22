SolrServer server = new CommonsHttpSolrServer(url);

SolrInputDocument document = new SolrInputDocument();
document.addField("tint", 1);

server.add(document);
server.commit();