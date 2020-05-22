final String url = "http://finance.yahoo.com/rss/topfinstories";

Document doc = Jsoup.connect(url).get();


for( Element item : doc.select("item") )
{
    final String title = item.select("title").first().text();
    final String description = item.select("description").first().text();
    final String link = item.select("link").first().nextSibling().toString();

    System.out.println(title);
    System.out.println(description);
    System.out.println(link);
    System.out.println("");
}