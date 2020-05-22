String userAgent = "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/42.0.2311.135 Safari/537.36";
String url = "https://www.premierleague.com/tables";

Document doc;
String position, club, played, won;

try {
    doc = Jsoup.connect(url).userAgent(userAgent).get();

    Element table = doc.select("table").first();

    for (Element row : table.select("tr")) {

        Elements cells = row.select("td");

        if(cells.size()<5) continue;

        position = cells.get(1).select(".value").first().text();
        club = cells.get(2).select(".long").first().text();
        played = cells.get(3).text();
        won = cells.get(4).text();

        System.out.println(position + " " + " " + club + "\n\tplayed: " + played + " won: " + won);

    }
} catch (IOException e) {
    e.printStackTrace();
}