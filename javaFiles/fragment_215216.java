static final String HOST = "https://somehost.com";

  public String sendPost(String method, Map<String, String> methodProperties) throws ClientProtocolException, IOException {

    HttpPost post = new HttpPost(HOST);  
    Gson gson = new Gson();

    Params params = new Params(method, methodProperties);
    StringEntity entity = new StringEntity(gson.toJson(params));   
    post.setEntity(entity);

    try (CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = httpClient.execute(post)) {

      return EntityUtils.toString(response.getEntity());
    }
  }