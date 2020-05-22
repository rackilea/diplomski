public String uploadRequest(String address, File img)
{
    HttpParams p = new BasicHttpParams();
    p.setParameter(CoreProtocolPNames.PROTOCOL_VERSION, HttpVersion.HTTP_1_1);
    DefaultHttpClient client = new DefaultHttpClient(p);

    HttpPost post = new HttpPost(address);

    // No need to add regular params as parts. You can if you want or
    // you can just tack them onto the URL as usual.
    MultipartEntityBuilder builder = MultipartEntityBuilder.create();
    builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
    builder.addPart("image", new FileBody(img));

    post.setEntity(builder.build());

    return client.execute(post, new ImageUploadResponseHandler()).toString();
}

private class ImageUploadResponseHandler implements ResponseHandler<Object>
{
    @Override
    public Object handleResponse(HttpResponse response) throws ClientProtocolException, IOException
    {
        HttpEntity responseEntity = response.getEntity();
        return EntityUtils.toString(responseEntity);
    }
}