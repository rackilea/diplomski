HttpClient httpclient = new DefaultHttpClient();
HttpGet httpget = new HttpGet(urltofetch);
HttpResponse response = httpclient.execute(httpget);
HttpEntity entity = response.getEntity();
if (entity != null) {
    long len = entity.getContentLength();
    InputStream inputStream = entity.getContent();
    // write the file to whether you want it.
}