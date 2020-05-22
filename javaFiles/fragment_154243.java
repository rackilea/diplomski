final String html = "<div style=\"overflow: visible;\" itemscope=\"\" itemtype=\"http://schema.org/Article\">\n"
        + "<meta itemprop=\"url\" content=\"http://www.somesite.com/index.html\">\n"
        + "<meta itemprop=\"headline\" content=\"some text\">\n"
        + "<meta itemprop=\"datePublished\" content=\"2015-01-26 12:37:00\">\n"
        + "<meta itemprop=\"dateModified\" content=\"2015-01-26 14:03:16\">";

Document doc = Jsoup.parse(html);

Element meta = doc.select("meta[itemprop=datePublished]").first();
String content = meta.attr("content");

System.out.println(content);