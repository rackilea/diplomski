private String performFastbillRequest(String InputJsonRequest) {
    String responseString = null;

    CloseableHttpClient client = HttpClients.createDefault();
    try {
        URI uri = URI.create(URL_SECURED_BY_BASIC_AUTHENTICATION);
        HttpPost post = new HttpPost(uri);
        String auth = getAuthentificationString();

        post.addHeader("Content-Type", "application/json");
        post.addHeader("Authorization", auth);

        StringEntity stringEntity = new StringEntity(InputJsonRequest);
        post.setEntity(stringEntity);

        CloseableHttpResponse response = client.execute(post);

        HttpEntity entity = response.getEntity();
        responseString = EntityUtils.toString(entity, "UTF-8");
   } catch (Exception e) {
       e.printStackTrace();
   }
   return responseString;
}