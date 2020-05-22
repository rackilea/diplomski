HttpGet httpRequest = null;

try {
    httpRequest = new HttpGet(url.toURI());
} catch (URISyntaxException e) {
    e.printStackTrace();
}

HttpClient httpclient = new DefaultHttpClient();

HttpResponse response = (HttpResponse) httpclient.execute(httpRequest);

HttpEntity entity = response.getEntity();

BufferedHttpEntity bufHttpEntity = new BufferedHttpEntity(entity);

InputStream instream = bufHttpEntity.getContent();

bmp = BitmapFactory.decodeStream(instream);