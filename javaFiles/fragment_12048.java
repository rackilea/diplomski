public String getMail() {    
    try {
        Document doc = Jsoup.connect("http://localhost14999/stackserver/index.jsp").get();
        Element table = doc.select("table").get(0);
        Elements rows = table.select("tr");

        Element row = rows.get(1);
        Elements cols = row.select("td");

        return cols.get(1).text();
    }catch(IOException e) {
        System.out.println(e.getMessage());
        System.out.println(e.toString());
        return "";
    }
}