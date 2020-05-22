CloseableHttpClient customClient = HttpClients.custom()
                    .setUserAgent("Your custom user agent string here")
                    .build();
String url = "http://stackoverflow.com/feeds/tag?tagnames=rome";
try (CloseableHttpClient client = customClient) {
    HttpUriRequest request = new HttpGet(url);
    try (CloseableHttpResponse response = client.execute(request);
        InputStream stream = response.getEntity().getContent()) {
        SyndFeedInput input = new SyndFeedInput();
        SyndFeed feed = input.build(new XmlReader(stream));
        System.out.println(feed.getTitle());
    }
}