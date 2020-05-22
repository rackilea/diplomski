public class NewsService implements NewsServiceInterface {
    private LinkedHashMap<String, String> store = new LinkedHashMap<>();

    public NewsService() throws IOException {
    }

    @Override
    public List<News> getNews() {
        Document doc = Jsoup.connect("http://www.up.krakow.pl/uniwersytet/aktualnosci").get();
        Elements links = doc.select("div.page-header");
        List<News> newsList = new ArrayList<>();
        for (Element element : links) {
            String title = element.select("a[href]").text(); // get only text
            String url = "http://www.up.krakow.pl" + element.select("a[href]").attr("href"); // get only link
            if (!store.containsKey(title)) {
                store.put(title, url);
            }
        }
        for (Map.Entry<String, String> entry : store.entrySet()) {
            newsList.add(new News(entry.getKey(), entry.getValue()));
        }
        return Lists.reverse(newsList);
    }
}