public static void main(String[] args) throws Exception {
 String url = "http://www.1channel.ch/latest_comments.php";
 Document doc = Jsoup.connect(url).get();
 for (Element E : doc.select("div.latest_comments)) {

  System.out.print("title: "+ E.select("a").text());
  System.out.println("comment: " + E.select("p").text());

 }
}