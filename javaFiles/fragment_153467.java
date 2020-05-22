private boolean uploadQueue(String username, String password, String filename, byte[] fileData)
{
    HttpClient client = HttpClientBuilder.create().build();
    String URL = "http://post.here.com:8080/";
    HttpPost post = new HttpPost(URL +"?username="+username+"&password="password);

    try
    {
        MultipartEntityBuilder entityBuilder = MultipartEntityBuilder.create();
        entityBuilder.addBinaryBody("filedata", fileData, ContentType.DEFAULT_BINARY, filename);
        entityBuilder.addTextBody("filename", filename);

        post.setEntity(entityBuilder.build());

        HttpResponse httpResponse = client.execute(post);

        if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK)
        {
            logger.info(EntityUtils.toString(httpResponse.getEntity()));

            return true;
        } 
        else
        {
            logger.info(EntityUtils.toString(httpResponse.getEntity()));

            return false;
        }
    }
    catch (Exception e)
    {
        logger.error("Error during Updload Queue phase:"+e.getMessage());
    }

    return false;
}