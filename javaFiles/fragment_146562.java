private static Strategy strategy = new AnnotationStrategy();
private static Serializer serializer = new Persister(strategy);

private static Retrofit.Builder builder =
        new Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .addConverterFactory(SimpleXmlConverterFactory.create(serializer));