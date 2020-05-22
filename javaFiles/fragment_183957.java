Response res = Jsoup.connect("http://en.wikipedia.org/wiki/Carbon")
            .execute();

    String html = res.body();

    Document doc = Jsoup.parseBodyFragment(html);
    Element body = doc.body();
    Elements tables = body.getElementsByTag("table");// hasClass("infobox bordered");

    for (Element table : tables) {

        if (table.className().equalsIgnoreCase("infobox bordered")) {
            System.out.println(table.outerHtml());
            break;
        }