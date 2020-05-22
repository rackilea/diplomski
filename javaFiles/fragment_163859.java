String rss = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
  +"<rss><channel>"
  +  "<title>The Blog Title</title>"
  +  "<link>http://www.the.blog/category</link>"
  +"</channel></rss>";

Document doc = Jsoup.parse(rss, "", Parser.xmlParser());

Element link = doc.select("rss channel link").first();
System.out.println(link.text()); // prints empty string