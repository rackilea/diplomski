private static URI createNode()
{
    final String nodeEntryPointUri = SERVER_ROOT_URI + "node";
    // http://localhost:7474/db/data/node

    WebResource resource = Client.create()
            .resource( nodeEntryPointUri );
    // POST {} to the node entry point URI
    ClientResponse response = resource.accept( MediaType.APPLICATION_JSON )
            .type( MediaType.APPLICATION_JSON )
            .entity( "{}" )
            .post( ClientResponse.class );

    final URI location = response.getLocation();
    System.out.println( String.format(
            "POST to [%s], status code [%d], location header [%s]",
            nodeEntryPointUri, response.getStatus(), location.toString() ) );
    response.close();

    return location;
}