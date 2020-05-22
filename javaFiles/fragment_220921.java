@Provides
@Singleton
ServerAPI provideServerAPI() {
    return new Retrofit.Builder()
            .baseUrl(ServerAPI.ENDPOINT)
            .client(client)
            .addConverterFactory(SimpleXmlConverterFactory.createNonStrict(new Persister(new AnnotationStrategy())))
            .build().create(ServerAPI.class);
}