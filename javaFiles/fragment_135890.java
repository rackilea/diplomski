class X {

  private static final HttpClient httpClient;

  static {
    SchemeRegistry defaultRegistery = new DefaultHttpClient().getConnectionManager()
                .getSchemeRegistry();
    ThreadSafeClientConnManager connMgr = new ThreadSafeClientConnManager(defaultRegistery);
    connMgr.setMaxTotalConnections(10);
    connMgr.setDefaultMaxPerRoute(10);
    httpClient = new DefaultHttpClient(connMgr);
    httpClient.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 30000);
  }

  public static InputStream simpleGetRequest(URL url, List<NameValuePair> queryString) throws ClientProtocolException, IOException {...}

  public static InputStream simpleGetRequest(URL url, List<NameValuePair> queryString) throws ClientProtocolException, IOException {...}

}