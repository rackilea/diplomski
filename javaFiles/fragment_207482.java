@Provides @Singleton
public RestAdapter providesRestAdapter()
{
    return new RestAdapter.Builder()
            .setEndpoint("http://192.168.0.23:9000/api")
            .setLogLevel(RestAdapter.LogLevel.FULL).build();
}

@Provides @Singleton
public RestApiProvider providesRestApiProvider(RestApiProviderImpl impl) {
    return impl;
}