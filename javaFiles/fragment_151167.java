public static void main(String[] args) throws Exception {
    System.out.println("Started");

    String url = "http://www.4icu.org/reviews/index2.htm";
    Document doc = Jsoup.connect(url).userAgent("Mozilla").get();

    Elements cells = doc.select("td.i");

    Iterator<Element> iterator = cells.iterator();

    while (iterator.hasNext()) {
        Element cell = iterator.next();
        String university = cell.select("a").text();
        String country = cell.nextElementSibling().select("img").attr("alt");

        System.out.printf("country : %s, university : %s %n", country, university);
    }
}