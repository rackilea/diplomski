Connection.Response response = Jsoup.connect(sitemapPath)
                        .userAgent("Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/535.21 (KHTML, like Gecko) Chrome/19.0.1042.0 Safari/535.21")
                        .timeout(10000)
                        .execute();

int statusCode = response.statusCode();
if(statusCode == 200) {
    Document doc = connection.get();
    Elements element = doc.select("loc");   
    for (Element urls : element) {
        System.out.println(urls.text());
    }
}
else {
    System.out.println("received error code : " + statusCode);
}