ODataClient client = ODataClientFactory.getClient(); 
// client.addHeader("Header","123456789"); // <---- this code is what I am seeking
URI customersUri = client.newURIBuilder("uri/northwindmodel.svc")
        .appendEntitySetSegment("Customers").build();

ODataEntitySetIteratorRequest<ClientEntitySet, ClientEntity> entitySetIteratorRequest =
        client.getRetrieveRequestFactory().getEntitySetIteratorRequest(qryUri);

entitySetIteratorRequest.addCustomHeader("Custom-Header-key", "Custom-Header-Value");

ODataRetrieveResponse<ClientEntitySetIterator<ClientEntitySet, ClientEntity>> response = entitySetIteratorRequest.execute();