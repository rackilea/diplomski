Document doc = Jsoup.connect("your_url").get();
Elements spans = doc.select("span[itemprop]");

for (Element span : spans) {
  System.out.println(span.text()); // will print 234 and 690
}