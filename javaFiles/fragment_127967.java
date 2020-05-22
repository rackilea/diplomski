int proxyPort = 8080;
String proxyHost = "proxyHost";
final String username = "username";
final String password = "password";

Authenticator proxyAuthenticator = new Authenticator() {
  @Override public Request authenticate(Route route, Response response) throws IOException {
       String credential = Credentials.basic(username, password);
       return response.request().newBuilder()
           .header("Proxy-Authorization", credential)
           .build();
  }
};

OkHttpClient client = new OkHttpClient.Builder()
    .connectTimeout(60, TimeUnit.SECONDS)
    .writeTimeout(60, TimeUnit.SECONDS)
    .readTimeout(60, TimeUnit.SECONDS)
    .proxy(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(proxyHost, proxyPort)))
    .proxyAuthenticator(proxyAuthenticator)
    .build();