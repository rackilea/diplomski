// Create the client.  We can cache and reuse this client because we're using a
    // ThreadSafeClientConnManager, which will create a pool of connections for us 
    // to use across multiple threads.
    HttpParams params = new BasicHttpParams();
    HttpConnectionParams.setSoTimeout(params, TIMEOUT);
    HttpConnectionParams.setConnectionTimeout(params, TIMEOUT);
    SchemeRegistry schemeRegistry = new SchemeRegistry();
    schemeRegistry.register(
            new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
    ClientConnectionManager cm = new ThreadSafeClientConnManager(params, schemeRegistry);
    httpClient = new DefaultHttpClient(cm, params);