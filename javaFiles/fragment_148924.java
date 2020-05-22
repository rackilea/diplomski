Document doc =
    Jsoup.connect(request)
         .userAgent("Mozilla/5.0 (compatible; Googlebot/2.1; +http://www.google.com/bot.html)")
         .timeout(5000).get();

Elements links = doc.select("a[href]");
for (Element link : links) {

    String temp = link.attr("href");
    if (temp.startsWith("/url?q=")) 
        result.add(temp);

}