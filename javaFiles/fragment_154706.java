public class ParsePage {
   private String path;
   Connection.Response response = null;

   private ParsePage(String langLocale){
      try {
         response = Jsoup.connect(path)
            .userAgent("Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/535.21 (KHTML, like Gecko) Chrome/19.0.1042.0 Safari/535.21")
            .timeout(10000)
            .execute();
      } catch (IOException e) {
         System.out.println("io - "+e);
      }
   }

   public int getSitemapStatus() {
      int statusCode = response.statusCode();
      return statusCode;
   }

   public ArrayList<String> getUrls() {
      ArrayList<String> urls = new ArrayList<String>();
      Document doc = response.parse();
      // do whatever you want, for example retrieving the <url> from the sitemap
      for (Element url : doc.select("url")) {
         urls.add(url.select("loc").text());
      }
      return urls;
   }
}