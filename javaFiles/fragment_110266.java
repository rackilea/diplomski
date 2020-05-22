final String test = "<article class=\"cik\" id=\"100\"><a class=\"ci\" href=\"/abc/1001/STUFF\"><img alt=\"Micky Mouse\" src=\"/images/1001.jpg\" /></a><div><a href=\"/abc/1001/STUFF\">Micky Mouse</a><span class=\"FP\">$88.00</span>&nbsp;&nbsp;<span class=\"SP\">$49.90</span></div></article>";
final Elements articles = Jsoup.parse(test).select("article");
for (final Element article : articles) {
    final Elements articleImages = article.select("> a[href] > img[src]");
    for (final Element image : articleImages) {
        System.out.println(image.attr("src"));
    }
    final Elements articleLinks = article.select("> div > a[href]");
    for (final Element link : articleLinks) {
        System.out.println(link.attr("href"));
        System.out.println(link.text());
    }
    final Elements articleFPSpans = article.select("> div > span.FP");
    for (final Element span : articleFPSpans) {
        System.out.println(span.text());
    }
}
    final Elements articleSPSpans = article.select("> div > span.SP");
    for (final Element span : articleSPSpans) {
        System.out.println(span.text());
    }
}