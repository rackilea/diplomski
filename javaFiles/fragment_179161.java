HttpParams params = new BasicHttpParams();
    // The params are read in the ctor of the pool constructed by
    // ThreadSafeClientConnManager, and need to be set before constructing it.
    ConnManagerParams.setMaxTotalConnections(params, 200);
    ConnPerRoute cpr = new ConnPerRoute() {
        @Override
        public int getMaxForRoute(HttpRoute httpRoute) {
            return 50;
        }
    };
    ConnManagerParams.setMaxConnectionsPerRoute(params, cpr);
    SchemeRegistry schemeRegistry = new SchemeRegistry();
    schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
    ClientConnectionManager cm = new ThreadSafeClientConnManager(params, schemeRegistry);