String userAgent = "Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.116 Safari/537.36";

try {
    // response needed to grab the cookies: res.cookies()
    Response res = Jsoup.connect("http://www.smbs.biz/ExRate/StdExRate.jsp")..timeout(10000)
            .userAgent(userAgent).method(Method.GET).header("Host", "www.smbs.biz").execute();

    Document doc = res.parse();

    String startDate = doc.getElementById("startDate").attr("value").replace(".", "-");
    String endDate = doc.getElementById("endDate").attr("value").replace(".", "-");

    doc = Jsoup.connect("http://www.smbs.biz/ExRate/StdExRate_xml.jsp?arr_value=USD_" + startDate+"_" + endDate)
            .userAgent(userAgent).timeout(10000).header("Host", "www.smbs.biz").cookies(res.cookies())
            .header("Connection", "keep-alive").method(Method.GET)
            .referrer("http://www.smbs.biz/ExRate/StdExRate.jsp").get();

    Elements elements = doc.select("chart > set");

    for (Element element : elements) {
        System.out.println(element.attr("label") + ": " + element.attr("value"));
    }

    Element currentRateElement = doc.select("chart > set").last();

    System.out.println("Current rate for " + currentRateElement.attr("label") + ": " + currentRateElement.attr("value"));

} catch (IOException e) {
    e.printStackTrace();
}