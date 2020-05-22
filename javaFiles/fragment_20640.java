CloseableHttpClient httpClient = HttpClients.createDefault();
try {
    FileBody bin = new FileBody(file);
    HttpEntity reqEntity = MultipartEntityBuilder.create().addPart("bin", bin).build();
    HttpPost httpPost = new HttpPost(url);
    httpPost.setEntity(reqEntity);

    CloseableHttpResponse postResponse = httpClient.execute(httpPost);
    try {
        writer.println(postResponse.getStatusLine());
        HttpEntity postResponseEntity = postResponse.getEntity();
        if (postResponseEntity != null) {
            writer.println(EntityUtils.toString(postResponseEntity));
        }
    } finally {
        postResponse.close();
    }
} finally {
    httpClient.close();
}