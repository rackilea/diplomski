try {
    HttpClient httpclient = new DefaultHttpClient();
    HttpPost post = new HttpPost(BASE_URI + "/services/users/login");

    // Setup form data
    List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
    nameValuePairs.add(new BasicNameValuePair("login", "blive1"));
    nameValuePairs.add(new BasicNameValuePair("password",
            "d30a62033c24df68bb091a958a68a169"));
    post.setEntity(new UrlEncodedFormEntity(nameValuePairs));

    // Execute request
    HttpResponse response = httpclient.execute(post);

    // Check response status and read data
    if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
        String data = EntityUtils.toString(response.getEntity());
    }
} catch (Exception e) {
    System.out.println(e);
}