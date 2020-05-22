LoadingCache<Request, Connection> requests = CacheBuilder.newBuilder()
       .maximumSize(1000)
       .expireAfterAccess(1, TimeUnit.MINUTES)
       .removalListener(MY_LISTENER)
       .build(
           new CacheLoader<Request, Connection>() {
             public Connection load(Request request) throws AnyException {
               return clientConnectionForRequest(request);
             }
           });