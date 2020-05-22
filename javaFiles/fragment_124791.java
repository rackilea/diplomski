private JSONObject sendJsonRequest(string host, int port,
       String uri, JSONObject param) 
            throws ClientProtocolException, IOException, JSONException
{
    HttpClient httpClient = new DefaultHttpClient();
    HttpHost httpHost = new HttpHost(host, port);   
    HttpPost httpPost = new HttpPost(uri);
    httpPost.addHeader("Content-Type", "application/json; charset=utf-8");

    if (param != null)
    {
        HttpEntity bodyEntity = new StringEntity(param.toString(), "utf8");
        httpPost.setEntity(bodyEntity);
    }

    HttpResponse response = httpClient.execute(httpHost, httpPost);
    HttpEntity entity = response.getEntity();

    String result = null;
    if (entity != null) {
        InputStream instream = entity.getContent();
        BufferedReader reader = new BufferedReader(
             new InputStreamReader(instream));
        StringBuilder sb = new StringBuilder();

        String line = null;
        while ((line = reader.readLine()) != null)
            sb.append(line + "\n");

        result = sb.toString();
        instream.close();           
    }

    httpPost.abort();
    return result != null ? new JSONObject(result) : null;
}