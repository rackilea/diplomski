public class googletest {
    public static void main(String[] args) throws IOException {

        Document doc = Jsoup
                .connect("private url"
                        )
                .get();
        Elements spans = doc.select("dd[itemprop=numDownloads]");
        System.out.println(spans.first().ownText());

    }

}