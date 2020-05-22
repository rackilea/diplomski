public static void main(String... args) throws IOException {
        File input = new File("C:/users/XYZ/desktop/input.html");
        Document doc = Jsoup.parse(input, "UTF-8", "");
        Elements tds = doc.getElementsByTag("td");
        for (Element td : tds) {
            System.out.println(td.text());
        }
    }