public static void main(String[] args) throws IOException {
        File file = new File("table.html");
        Document doc = Jsoup.parse(file, "utf-8");
        for (Element table : doc.select("table[id=statisticsTable]")) {
            Elements rows = table.select("tbody tr");
            System.out.println("found rows: " + rows.size());
            rows.remove(rows.first()); // Removing first row: "Total->3640"
            for (Element row : rows) {
                Elements tds = row.select("td:not([rowspan])");
                System.out.println(tds.get(0).text() + "->" + tds.get(1).text());
            }
        }
    }