Document document = Jsoup.parse(html);

    Elements elements = document.select("#tableMain tr:has(td.location) + tr");

    for (Element element : elements) {
        String location = element.previousElementSibling().select("td.location").text();

        System.out.printf("Current location: '%s'%n", location);

        Elements titleLists = element.select("#titleList > tbody > tr");

        for (Element tr : titleLists) {
            String title = tr.select("td.title").text();
            String date = tr.select("td.date").text();
            String time = tr.select("td.time").text();

            System.out.printf("Title: %s, Date: %s, Time: %s%n", title, date, time);
        }
    }