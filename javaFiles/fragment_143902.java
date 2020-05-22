public static void main(String[] args) throws MalformedURLException {
    URL url = new URL( "http://tw.search.bid.yahoo.com/search/"
            + "ac;_ylt=AtqkyTO06sgGHho20HzmPEX3_rF8?ei=UTF-8&p=%E8%A1%A3%E6%9C%8D");

    Document doc;
    try {
        doc = Jsoup.parse(url, 3000);
        Elements descriptions = doc.select("div#srp_sl_result div.att-item");

        for (Element element : descriptions) {
            System.out.println(element.text());
            System.out.println("--------------");
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}