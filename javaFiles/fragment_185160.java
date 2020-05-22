URIBuilder statusBuilder = new URIBuilder("https://westus.api.cognitive.microsoft.com/emotion/v1.0/operations/{oid});
statusBuilder.setParameter("oid", {oid});

URI uriStatus = statusBuilder.build();
HttpGet statusRequest = new HttpGet(uriStatus);
statusRequest.setHeader("Ocp-Apim-Subscription-Key", {key});

HttpResponse statusResponse = httpclient.execute( statusRequest );
HttpEntity entity = statusResponse.getEntity();
Header[] statusHeaders = statusResponse.getAllHeaders();
    for (Header header : statusHeaders) {
        System.out.println( "Key : " + header.getName()
            + " ,Value : " + header.getValue() );
    }