try {
    int maxPage = 3681;
    int i = 0;
    for (int page = 0; page < maxPage; ++page) {
        Document doc = Jsoup.connect(
            "https://ndb.nal.usda.gov/ndb/search/list"
            + "?maxsteps=6&format=&count=&max=50"
            + "&sort=fd_s&fgcd=&manu=&lfacet=&qlookup=&ds="
            + "&qt=&qp=&qa=&qn=&q=&ing=&offset=" + (page * 50)
            + "&order=asc")
            .userAgent("mozilla/17.0").get();
        Elements rows = doc.select("div.list-left table tbody tr");
        for (Element row : rows) {
            ++i;
            System.out.print("No." + i);
            System.out.print(" ID=" + row.select("td:eq(1) a").text());
            System.out.println(" Manufacturer=" + row.select("td:eq(3) a").text());
        }
    }
} catch (IOException e) {
    e.printStackTrace();
}