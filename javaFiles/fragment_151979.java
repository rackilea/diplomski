public void crawl(String url) throws IOException {
    Document doc = Jsoup.connect(url).get();
    Elements links = doc.select("a");

    for (Element link : links) {
        String foundUrl = link.attr("abs:href").toLowerCase();

        if( isSuitable(foundUrl) && ( !hs.contains(foundUrl) ) ) {
            hs.add(foundUrl);
            crawl(foundUrl);
        }
    }
}