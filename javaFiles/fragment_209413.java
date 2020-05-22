final String url = "https://accounts.spotify.com/api/token";
    CloseableHttpClient client = HttpClients.createDefault();
    HttpPost httpPost = new HttpPost(url);

    httpPost.setHeader(HttpHeaders.CONTENT_TYPE, "application/x-www-form-urlencoded");
    httpPost.setHeader(HttpHeaders.AUTHORIZATION, "Basic " + Base64.encodeBase64String(("2...0" + ":" + "4...9").getBytes()));
    StringEntity data = new StringEntity("grant_type=authorization_code&&code=" + req.getParameter("code") + "&&redirect_uri=http://localhost:8081/callback");
    httpPost.setEntity(data);

    HttpResponse response = client.execute(httpPost);