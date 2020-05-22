// Compose the URI and create a HttpConnection to GET it

    URI listRequestURI = new URI(db.getDBUri().toString() 
                                 + "/_design/your-designdoc/_list/your-list/your-view");

    HttpConnection listRequest = Http.GET(listRequestURI);

    // Execute the request and get the response

    HttpConnection listResponse = account.executeRequest(listRequest);

    // Get the response in the desired format and process
    listResponse.responseAsString();
    // or responseAsBytes()
    // or responseAsInputStream()