@Override
public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
    configurer.defaultContentType(MediaType.APPLICATION_XML)
    .mediaType("json", MediaType.APPLICATION_JSON)
    .mediaType("xml", MediaType.APPLICATION_XML);

    configurer.defaultContentTypeStrategy(new ContentNegotiationStrategy() {
        @Override
        public List<MediaType> resolveMediaTypes(NativeWebRequest webRequest) throws HttpMediaTypeNotAcceptableException {
            // If you want handle different cases by getting header with webRequest.getHeader("accept")
            return Arrays.asList(MediaType.APPLICATION_JSON);
        }
    });       
}