DefaultHttpClient httpclient = new DefaultHttpClient();
    HttpPost httpPost = new HttpPost("https://api.bitbucket.org/1.0/repositories/"
            + accountname + "/" + repo_slug + "/issues/");
    List<NameValuePair> nvps = new ArrayList<NameValuePair>();
    nvps.add(new BasicNameValuePair("title", "test"));
    nvps.add(new BasicNameValuePair("content", "testtest"));
    httpPost.setEntity(new UrlEncodedFormEntity(nvps));
    consumer.sign(httpPost); 
    HttpResponse response2 = httpclient.execute(httpPost);

    try {
        System.out.println(response2.getStatusLine());
        HttpEntity entity2 = response2.getEntity();
        // do something useful with the response body
        // and ensure it is fully consumed
        EntityUtils.consume(entity2);
    } finally {
        httpPost.releaseConnection();
    }

}