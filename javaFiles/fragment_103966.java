String xml = "<link>One</link><link>Two</link>";
Document xmlDoc = Jsoup.parse(xml, "", Parser.xmlParser());

Elements links = xmlDoc.select("link");
System.out.println("Link text 1: " + links.get(0).text());
System.out.println("Link text 2: " + links.get(1).text());