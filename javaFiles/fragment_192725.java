public static void main(String[] args) throws IOException {

    List<String> list = new ArrayList<String>(); // THIS LINE IS NEW

    Document doc = Jsoup.connect("http://espn.go.com/nhl/team/stats/_/name/phi/philadelphia-flyers").get();

    for (Element table : doc.select("table.tablehead")) {
        for (Element row : table.select("tr")) {
            Elements tds = row.select("td");
             if (tds.size() > 6) {
                String a = tds.get(0).text() + ":" + tds.get(1).text() + " GOALS: " + tds.get(2).text() + " ASSISTS: " + tds.get(3).text() + " POINTS: " + tds.get(4).text() + " PLUS/MINUS: " + tds.get(5).text() + " PIM: " + tds.get(6).text();

                    list.add(a);  // THIS LINE IS NEW

                System.out.println(a);
            }
        }
    }

        // at this point, variable "list" contains each String assigned to "a" above.

}