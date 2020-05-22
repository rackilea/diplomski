// load page using HTML Unit and fire scripts
WebClient webClient = new WebClient();
HtmlPage myPage = webClient.getPage("http://www.airfrance.fr/vols/paris+tunis");

// convert page to generated HTML and convert to document
Document doc = Jsoup.parse(myPage.asXml());

// find all of the date/price cells
for(Element cell : doc.select("td.available.daySelection")) {
    String cellDate = cell.select(".cellDate").text();
    String cellPrice = cell.select(".cellPrice > .day_price").text();
    System.out.println(
            String.format(
                    "cellDate=%s cellPrice=%s", 
                    cellDate, 
                    cellPrice));
}

// clean up resources        
webClient.close();