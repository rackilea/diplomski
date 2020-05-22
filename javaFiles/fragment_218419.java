String html = "<a href=\"/name/zola-1\">ZOLA <span class=\"tiny\">(1)</span></a>";

Document doc = Jsoup.parse(html);
Elements links = doc.getElementsByTag("a");
System.out.println(links.get(0));
System.out.println(links.get(0).ownText());