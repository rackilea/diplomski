// load page and capture DOM
    WebClient webClient = new WebClient();
    HtmlPage myPage = webClient.getPage("https://www.google.com/finance?q=apple");

    // convert to jsoup document
    Document doc = Jsoup.parse(myPage.asXml());

    // clean up resources
    webClient.close();

    // select desired data
    Elements rows = doc.select("table#cc-table > tbody > tr");

    for (Element row : rows) {
        String symbol = row.select("td.ctsymbol").text();
        String name = row.select("td.ctname").text();
        String price = row.select("td.rgt").first().text();
        System.out.println(symbol + " " + name + " " + price);
    }