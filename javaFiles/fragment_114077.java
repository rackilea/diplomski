MultipartPostMethod method =
        new MultipartPostMethod( "http://localhost:8080/sendfile" );
                   method.addParameter("mediaFile", multifile );
   HttpClient client1 = new HttpClient( );
// Execute and print response
    client1.executeMethod( method );
    String response = method.getResponseBodyAsString( );
    System.out.println( response );
    method.releaseConnection( );
    return response;