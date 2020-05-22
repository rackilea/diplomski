String json = null;

// Making HTTP request
try {
    // defaultHttpClient
    DefaultHttpClient httpClient = new DefaultHttpClient();
    HttpPost httpPost = new HttpPost(url);

    HttpResponse httpResponse = httpClient.execute(httpPost);
    HttpEntity httpEntity = httpResponse.getEntity();
    is = httpEntity.getContent();

    BufferedReader reader = new BufferedReader(new InputStreamReader(
            is, "iso-8859-1"), 8);
    StringBuilder sb = new StringBuilder();
    String line = null;
    while ((line = reader.readLine()) != null) {
        sb.append(line + "\n");
    }
    is.close();
    json = sb.toString();
} catch (UnsupportedEncodingException e) {
    e.printStackTrace();
} catch (ClientProtocolException e) {
    e.printStackTrace();
} catch (IOException e) {
    e.printStackTrace();
}