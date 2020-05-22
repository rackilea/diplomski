RestAdapter.Builder builder= new RestAdapter.Builder()
   .setRequestInterceptor(new RequestInterceptor() {
        @Override
        public void intercept(RequestFacade request) {
            request.addHeader("Accept", "application/json;versions=1");
            if (MyApplicationUtils.isNetworkAvailable(context)) {
                int maxAge = 60; // read from cache for 1 minute
                request.addHeader("Cache-Control", "public, max-age=" + maxAge);
            } else {
                int maxStale = 60 * 60 * 24 * 28; // tolerate 4-weeks stale
                request.addHeader("Cache-Control", 
                    "public, only-if-cached, max-stale=" + maxStale);
            }
        }
});