//Get the document
Document doc =   Jsoup.connect("https://www.youtube.com/").get();

//Get all the hyperlinks
Elements links = doc.select("a[href]");
//Loop through them
for (Element element : links) {
     System.out.println("href: " + element.absUrl("href"));
}

//Get all script elements with src
Elements scriptSources = doc.select("[src]");
//Loop through them
for (Element element : scriptSources) {
     System.out.println("src:" + element.absUrl("src"));
}