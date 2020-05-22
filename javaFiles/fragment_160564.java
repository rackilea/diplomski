String html = responseBodyResponse.body().toString();

Document document = Jsoup.parse(html);

Elements elements = doc.select("div.product-tuple-description");
for (Element element : elements) {
    String link = element.select("a.dp-widget-link").first().attr("href");
    String title = element.select("p.product-title").first().attr("title");
    String price = element.select("span.product-price").first().text();

    System.out.println(String.format("Link=%s, Title=%s, Price=%s", link, title, price));
}