String url = "http://www.skysports.com/football/competitions/la-liga/table";
    try {
        Document document = Jsoup.connect(url).timeout(0).get();
        Elements clubRow = document.select("tr.standing-table__row");
        for(Element club: clubRow) {
            System.out.println(club.select("a.standing-table__cell--name-link").text());
        }
    } catch (IOException e) {
        e.printStackTrace();
    }