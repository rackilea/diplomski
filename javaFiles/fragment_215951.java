// To parse the html page
Document doc = Jsoup.connect("http://www.website.com").get();
Document doc1 = Jsoup.parse("<html><head><title>First parse</title></head>" + "<body> <p>Parsed HTML into a doc.</p></body></html>");

String content = doc.body().text();

// To get specific elements such as links
Element links = doc.select("a[href]");
for(Element e: links){
    System.out.println("link: " + e.attr("abs:href"));
}