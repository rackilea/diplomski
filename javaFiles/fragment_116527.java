private void initialize(HttpPost method)
{
    String body = "body";
    HttpEntity entity = new ByteArrayEntity(body.getBytes("UTF-8"));
    method.setEntity(entity);
}