// Only one line to parse an external content
Document doc = Jsoup.connect("http://jsoup.org").get();

// "Javascript-like" syntax
Element content = doc.getElementById("content");
Elements links = content.getElementsByTag("a");
for (Element link : links) {
  String linkHref = link.attr("href");
  String linkText = link.text();
}

// "Jquery/Css-like" syntax
Elements resultLinks = doc.select("h3.r > a");
Elements pngs = doc.select("img[src$=.png]");