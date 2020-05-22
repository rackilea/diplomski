SPARQLRepository repo = new SPARQLRepository(endpoint);

// create a new map of additional http headers
Map<String, String> headers = new HashMap<String, String>();

// we set the Accept header to _only_ accept text/plain, forcing the endpoint
// to use N-Triples as the response format. This overwrites the standard
// Accept header that RDF4J sends.
headers.put("Accept", "text/plain");
repo.setAdditionalHttpHeaders(headers);