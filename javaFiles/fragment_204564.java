public static void main(String[] args){
    String url = "http://www.world-food.ru/ru-RU/about/exhibitor-list.aspx";
    String userAgent = "Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:55.0) Gecko/20100101 Firefox/55.0";
    try {
        Response  response = Jsoup.connect(url).execute();
        Document document = response.parse();

        String viewState = encode(document.getElementById("__VIEWSTATE").attr("value"), "UTF-8");
        String eventTarget = encode("p$lt$ctl12$pageplaceholder$p$lt$ctl01$UniPager$pagerElem", "UTF-8");

        for(int i = 1; i < 72; ++i) {
            document = Jsoup.connect(url).userAgent(userAgent)
                .requestBody(
                        String.format(
                                "__EVENTTARGET=%s"
                                + "&__EVENTARGUMENT=%d"
                                + "&__VIEWSTATE=%s",
                                eventTarget, i, viewState ))
                .cookies(response.cookies())
                .post();

            Elements list = document.getElementsByClass("name showframe");

            for (int x = 0; x < list.size() ; x++) {
                System.out.println(list.get(x).html() + " \n" + list.get(x).absUrl("href"));
            }
        }
    } catch (Exception ex) {
        // TODO Handle exceptions
        ex.printStackTrace();
    }
}