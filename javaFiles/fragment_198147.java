Document doc = Jsoup
        .connect("http://pubedt.uvsq.fr/VER/g4227.html")
        .header("User-Agent",
                "Mozilla/5.0 (X11; Linux x86_64) Gecko/20100101 Firefox/19.0")
        .timeout(100 * 1000).get();
for (Element table : doc.select("table")) {
    // System.out.println(table.html());
    for (Element row : table.select("tr")) {
        Elements tds = row.select("td");
        // log added here
        System.out.println("tds.size(): " + tds.size());
        if (tds.size() > 6) {
            System.out.println(tds.get(0).text() + ":"
                    + tds.get(1).text());
        }
    }
}