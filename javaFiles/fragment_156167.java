RestAdapter restAdapter = new RestAdapter.Builder()
    .setErrorHandler(new ErrorRetrofitHandlerException())
    .setEndpoint(urlBase)
    .setLogLevel(RestAdapter.LogLevel.FULL)
    .setClient(new OkClient(new OkHttpClient()))
    .build();