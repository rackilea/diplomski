Document doc = Jsoup.connect(catUrl).get();
Elements products = doc.select("div.f-icon.m-item h2.title a[href]");
for(Element prodUrl: products){
    System.out.println(prodUrl.attr("href"));
    itemUrls.addItem(prodUrl.attr("href"));
}