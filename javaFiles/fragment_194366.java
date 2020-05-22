CloseableHttpClient client = HttpClientBuilder.create().build();
BasicHttpRequest request = new BasicHttpRequest("GET", "all kind of c%.p");

try (CloseableHttpResponse response1 = client.execute(new HttpHost("www.google.com"), request)) {
    System.out.println(response1.getStatusLine());
    EntityUtils.consume(response1.getEntity());
}