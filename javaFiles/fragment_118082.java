String url = "https://yoururl.com"; 

    HttpClient client = new DefaultHttpClient();
    HttpPost post = new HttpPost(url);

    // add header
    post.setHeader("User-Agent", USER_AGENT);

    List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
    urlParameters.add(new BasicNameValuePair("xml", xmlString));

    post.setEntity(new UrlEncodedFormEntity(urlParameters));

    HttpResponse response = client.execute(post);
    System.out.println("\nSending 'POST' request to URL : " + url);
    System.out.println("Post parameters : " + post.getEntity());
    System.out.println("Response Code : " + 
                                response.getStatusLine().getStatusCode());

    BufferedReader rd = new BufferedReader(
                    new InputStreamReader(response.getEntity().getContent()));

    StringBuffer result = new StringBuffer();
    String line = "";
    while ((line = rd.readLine()) != null) {
        result.append(line);
    }

    System.out.println(result.toString());