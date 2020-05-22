public static void main(String[] args) throws IOException {
    Document doc = Jsoup.connect("https://ms.wikipedia.org/wiki/Malaysia").get();
    Element table = doc.select("span#Trivia").parents().first().nextElementSibling();
    Elements rows = table.select("tr");
    for (Element row : rows) {
        String header = row.select("th").text();
        String value = row.select("td").text();
        System.out.println(header + ": " + value);
    }
}