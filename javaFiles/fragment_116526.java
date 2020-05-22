private void initialize(HttpRequestBase method)
{
    if(method instanceof HttpPost)
    {
        String body = "body";
        HttpEntity entity = new ByteArrayEntity(body.getBytes("UTF-8"));
        ((HttpPost) method).setEntity(entity);
    }
}