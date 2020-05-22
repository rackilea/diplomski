HttpClient client = new DefaultHttpClient();
    HttpPost post = new HttpPost(SANBOX_URL);
    post.setHeader("User-Agent", "Mozilla/5.0"); 
    List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
    urlParameters.add(new BasicNameValuePair(USER, "SANDBOX_USER"));
    urlParameters.add(new BasicNameValuePair(PASSWORD, "SANDBOX_PWD"));
    urlParameters.add(new BasicNameValuePair(SIGNATURE, "SANDBOX_SIGNATURE"));
    urlParameters.add(new BasicNameValuePair(VERSION, "VERSION"));
    urlParameters.add(new BasicNameValuePair(ACTION, "ACTION"));
    urlParameters.add(new BasicNameValuePair(AMOUNT, "AMOUNT"));
    urlParameters.add(new BasicNameValuePair(RETURN_URL, "RETURN_URL"));
    urlParameters.add(new BasicNameValuePair(CANCEL_URL, "CANCEL_URL"));
    urlParameters.add(new BasicNameValuePair(METHOD, "METHOD"));

    post.setEntity(new UrlEncodedFormEntity(urlParameters));

    HttpResponse response = client.execute(post);