// Setup proxy
String proxyAdress = "1.2.3.4";
int proxyPort = 1234;
Proxy proxy = new Proxy(Proxy.Type.HTTP, InetSocketAddress.createUnresolved(proxyAdress, proxyPort))

// Fetch url with proxy
Document doc = Jsoup //
               .proxy(proxy) //
               .userAgent("Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2") //
               .header("Content-Language", "en-US") //
               .connect(searchUrl) //
               .get();