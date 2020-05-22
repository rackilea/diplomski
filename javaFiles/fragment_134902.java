List<String> hrefs = new ArrayList<>();
try {
    Document doc = Jsoup.connect("http://livechennai.com/powershutdown_news_chennai.asp").get();

    // more specific element specification, as in the question
    // Elements table = doc.select("#table13>tbody>tr>td>a");

    // less specific as mentioned by Jonathan
    Elements table = doc.select("#table13 a");

    for (Element link : table) {
        hrefs.add(link.attr("abs:href"));
    }
} catch (IOException e) {
    e.printStackTrace();
}
// here you can process all hrefs
for (String href : hrefs) {
    System.out.println(href);
}