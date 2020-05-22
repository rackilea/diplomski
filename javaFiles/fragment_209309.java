Document root = Jsoup.parse(new URL("http://en.wikipedia.org/wiki/List_of_cities_and_towns_in_India"), 30000);
    //find all tables
    Elements tables = root.select("table");
    for (int m = 0; m < tables.size(); m++) {
        final Element table = tables.get(m);
        Elements th0 = table.select("tbody tr th");
        //find our tables
        if (th0 != null && th0.get(0).text().trim().equals("Name of City/Town")) {
            Elements es = table.select("tbody tr");
            for (int i = 1; i < es.size(); i++) {
                Elements td = es.get(i).select("td");
                String city = td.get(0).select("a").first().text();
                String state = td.get(1).select("a").first().text();
                System.out.println(city + " => " + state);
            }
        }
    }