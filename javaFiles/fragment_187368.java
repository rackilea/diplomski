String url = "http://www.ub.edu/web/ub/en/";
Document doc = Jsoup.connect(url).get();
Elements links = doc.select("a[href]");

List<String> listOfLinks = new ArrayList<>();
for (Element link : links){
    listOfLinks.add(link.attr("abs:href"));
}

System.out.println(listOfLinks);