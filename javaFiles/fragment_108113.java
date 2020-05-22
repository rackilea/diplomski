public class Test {
  public static void main(String[] args) throws URISyntaxException {
    ImmutableList<String> urls = ImmutableList.of(
        "http://example.google.com", "http://google.com", 
        "http://bing.bing.bing.com", "http://www.amazon.co.jp/");
    for (String url : urls) {
      System.out.println(url + " -> " + getTopPrivateDomain(url));
    }
  }

  private static String getTopPrivateDomain(String url) throws URISyntaxException {
    String host = new URI(url).getHost();
    InternetDomainName domainName = InternetDomainName.from(host);
    return domainName.topPrivateDomain().name();
  }
}