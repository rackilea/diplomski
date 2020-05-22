public class JsoupSteamTest {

    public static void main(String[] args) throws IOException {

        Document doc = Jsoup.connect("http://store.steampowered.com/search/?filter=topsellers").userAgent("Mozilla")
                .get();

        Elements table = doc.select("a.search_result_row");

        Iterator<Element> ite = table.iterator();
        while (ite.hasNext()) {
            Element element = ite.next();
            System.out.println(element.text());

        }
    }
}