Document doc = Jsoup.connect("http://www.tsn.ca/fantasy_news/feature/?ID=49815").get();

    for (Element table : doc.select("div.storyStats").select("table")) {
        for (Element row : table.select("tr")) {
            Elements tds = row.select("td");
            if (tds.size() > 0) {
                System.out.println(tds.get(1).text() + ":" + tds.get(5).text());
            }
        }
    }