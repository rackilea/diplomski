// connect to your solr server
SolrServer server = new HttpSolrServer("http://HOST:8983/solr/");

// adding a single document
SampleDocument document = new SampleDocument(1, "title 1");
server.addBean(document);

// adding multiple documents
List<SampleDocument> documents = Arrays.asList(
        new SampleDocument(2, "title 2"), 
        new SampleDocument(3, "title 3"));
server.addBeans(documents);

// commit changes
server.commit();

// query solr for something
QueryResponse response = server.query(new SolrQuery("*:*"));
// get the response as List of POJO type
List<SampleDocument> foundDocuments = response.getBeans(SampleDocument.class);