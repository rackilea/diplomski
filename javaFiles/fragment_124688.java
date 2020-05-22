public GenericResponse processHttpPostRequest( String host, String path,String content, Map<String, String> parameters, String multiPartDataBounadry ,String outfilePath)
{
    CloseableHttpClient httpclient = null;

    GenericResponse response = null;
    try
    {
        //This is important to integrate eclipse with fiddler
        HttpHost proxy = new HttpHost("localhost", 8888);

        HttpPost httpPost = new HttpPost( createPostURI( host, path,parameters) );


        setHeader(multiPartDataBounadry, httpPost);

        //This is important to integrate eclipse with fiddler
        httpclient = HttpClients.custom().setProxy(proxy).disableContentCompression().build(); 
        //httpclient = HttpClients.createDefault();

        HttpEntity entity = setRequestBody(content, multiPartDataBounadry);

        httpPost.setEntity( entity );

        LOGGER.info( "Executing request URI " + httpPost.getURI() );

        response = httpclient.execute( httpPost, new GenericResponseHandler() );
        handleResponse(response, outfilePath);

        if (response.getStatusCd() != 200)
        {
            handleResponseError(parameters, response);
        }

    }
    catch(Throwable e)
    {
        e.printStackTrace();
        throw new RuntimeException(e);
    }

    finally
    {
        closeClient(httpclient);
    }

    return response;
}

private void setHeader(String multiPartDataBounadry, HttpEntityEnclosingRequestBase httpEntity) 
{
    httpEntity.setHeader("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10.8; rv:22.0) Gecko/20100101 Firefox/22.0");
    httpEntity.setHeader("Content-Type", "multipart/form-data; boundary="+multiPartDataBounadry);
    httpEntity.setHeader("Accept", "application/json");
}

private HttpEntity setRequestBody(String content, String multiPartDataBounadry) 
{
    FormBodyPart bodyPart = FormBodyPartBuilder.create()                    
            .setName("any_name")
            .addField("Content-Disposition", "form-data; name=\"categoryFile\"; filename=\"self-classification-categories.tsv\"")
            .setBody(new StringBody(content, ContentType.MULTIPART_FORM_DATA))
            .build();

    MultipartEntityBuilder builder = MultipartEntityBuilder.create()
            .setMode(HttpMultipartMode.BROWSER_COMPATIBLE)
            .setBoundary(multiPartDataBounadry)
            .addPart(bodyPart);

    HttpEntity entity =   builder.build();

    return entity;

}


private URI createPostURI( String host, String path , Map<String, String> parameters) throws Exception
{
    URI finalURL = null;
    try
    {
        URIBuilder url = null;
        url = new URIBuilder();
        url.setScheme( "http" );
        url.setHost( host );
        url.setPath( path );
        url.setParameter("first_param", "first_param_value");
        url.setParameter("second_param","second_param_value");

        finalURL =  url.build() ;

    }
    catch ( URISyntaxException |  IllegalArgumentException  e )
    {
        e.printStackTrace();
        throw e;
    }

    return finalURL;
}