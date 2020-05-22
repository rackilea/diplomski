Connection connection = Jsoup.connect("http://www.garazh.com.ua/tires/catalog/Marangoni/E-COMM/description/");
connection
    .header("Host", host)
    .header("User-Agent", UA)
    .header("Accept", "text/html,application/xhtml+xml,application/xmlq=0.9,*/*q=0.8")
    .header("Accept-Language", "ru-ru,ruq=0.8,en-usq=0.5,enq=0.3")
    .header("Accept-Encoding", "gzip,deflate")
    .header("Accept-Charset", "utf-8q=0.7,*q=0.7")
    .header("Keep-Alive", "115")
    .header("Connection", "keep-alive");

connection.followRedirects(true);

Document doc = connection.get();

Map<String, String> cookies = connection.response().cookies();

Elements titles = doc.select(".title");
for( Element title : titles ) {
    System.out.println(title.ownText());
}