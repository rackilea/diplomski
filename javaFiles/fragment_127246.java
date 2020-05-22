CloseableHttpClient httpclient = HttpClients.createDefault();
String url = "http://api.search.yahoo.com/WebSearchService/V1/webSearch?appid=YahooDemo&query=umbrella&results=10";
HttpGet httpget = new HttpGet(url);
CloseableHttpResponse response = httpclient.execute(httpget);
try {
    HttpEntity entity = response.getEntity();
    InputStream is = entity.getContent();

    //do stuff with is
} finally {
    response.close();
}