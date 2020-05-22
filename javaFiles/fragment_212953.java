String userAgent = "Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.116 Safari/537.36";
String searchTerm = "stackoverflow";
int numberOfResultpages = 2; // grabs first two pages of search results
String searchUrl = "https://www.google.com/search?";

Document doc;

for (int i = 0; i < numberOfResultpages; i++) {

    try {
        doc = Jsoup.connect(searchUrl)
                .userAgent(userAgent)
                .data("q", searchTerm)
                .data("tbm", "nws")
                .data("start",""+i)
                .method(Method.GET)
                .referrer("https://www.google.com/").get();

        for (Element result : doc.select("#rso > div")) {

            if(result.select("div.st").size()==0) continue;

            Element h3a = result.select("h3 > a").first();

            String title = h3a.text();
            String url = h3a.attr("href");
            String preview = result.select("div.st").first().text();

            // just printing out title and link to demonstate the approach
            System.out.println(title + " -> " + url + "\n\t" + preview);
        }

    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
}