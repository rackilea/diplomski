class RESTClient extends BoxRESTClient {

  final HttpClient httpClient;

  @SuppressWarnings("deprecation")
  RESTClient() {
    super();
    SchemeRegistry schemeReg = new SchemeRegistry();
    schemeReg.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
    SSLSocketFactory socketFactory;
    try {
      socketFactory = new SSLSocketFactory(SSLSocketFactory.TLS,
                                         null,
                                         null,
                                         null,
                                         null,
                                         null,
                                         SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
    } catch (Exception ex) {
      throw new IllegalStateException("Failure initializing default SSL context for Box REST client", ex);
    }
    schemeReg.register(new Scheme("https", socketFactory, 443));
    ClientConnectionManager connectionManager = new ThreadSafeClientConnManager(new BasicHttpParams(), schemeReg);
    this.httpClient = new DefaultHttpClient(connectionManager);
  }

  @Override
  public HttpClient getRawHttpClient() {
    return httpClient;
  }
}