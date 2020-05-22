protected String doLoginPost(String url, String username, String password) throws Exception {

    HttpClient client = new DefaultHttpClient();
    HttpPost post = new HttpPost(url);

    List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
    urlParameters.add(new BasicNameValuePair("username", username));
    urlParameters.add(new BasicNameValuePair("password", password));
    post.setEntity(new UrlEncodedFormEntity(urlParameters));

    HttpResponse response = client.execute(post);
    L.info("\nSending 'POST' request to URL : " + url);
    L.info("Post parameters : " + post.getEntity());
    L.info("Response Code : " +
            response.getStatusLine().getStatusCode());
    if (response.getStatusLine().getStatusCode() != 200) {
        return null;
    }
    BufferedReader rd = new BufferedReader(
            new InputStreamReader(response.getEntity().getContent()));

    StringBuffer result = new StringBuffer();
    String line = "RESULT: ";
    result.append(line);
    while ((line = rd.readLine()) != null) {
        result.append(line);
    }

    return result.toString();
}