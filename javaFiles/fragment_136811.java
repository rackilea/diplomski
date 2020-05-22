KeyStore trustStore = KeyStore.getInstance("JKS");
trustStore.load(new FileInputStream("myTrustStore.jks"), trustStorePassword);
SSLSocketFactory sf = new SSLSocketFactory(trustStore);
Scheme httpsScheme = new Scheme("https", 443, sf);
SchemeRegistry schemeRegistry = new SchemeRegistry();
schemeRegistry.register(httpsScheme);
ClientConnectionManager cm = new SingleClientConnManager(schemeRegistry);
HttpClient httpClient = new DefaultHttpClient(cm);