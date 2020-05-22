Document doc;
try {
    String keyword = "google hyderabad";
    doc = Jsoup //
            .connect("http://www.business-standard.com/search?q=" + URLEncoder.encode(keyword, "UTF-8")) //
            .userAgent("Mozilla") //
            .get();

    String title = doc.title();
    System.out.println("title : " + title);

    Elements links = doc.select("a:contains(google)");
    for (Element link : links) {
        System.out.println("\nlink : " + link.absUrl("href"));
        System.out.println("text : " + link.text());
    }
} catch (IOException e) {
    e.printStackTrace();
}