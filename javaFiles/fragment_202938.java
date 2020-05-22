ArrayList<String> titles = new ArrayList<String>();
ArrayList<String> urls = new ArrayList<String>();

Document doc = Jsoup.parse(result);
Elements links = doc.select("div.stationcol > a[href]");

for (Element e : links) {
    titles.add(e.attr("title"));
    urls.add(e.attr("href"));
}

System.out.println(titles);
System.out.println(urls);