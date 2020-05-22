Document document = Jsoup.connect("http://finance.yahoo.com/q/p?s=+AAPL+Press+Releases")
                         .get();
    Element div = document.select("div.mod.yfi_quote_headline.withsky").first();
    Elements aHref = div.select("a[href]");
    for(Element element : aHref)
        System.out.println(element.attr("abs:href"));