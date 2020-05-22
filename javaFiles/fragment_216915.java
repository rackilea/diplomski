@Bean
public RequestMappingHandlerAdapter requestMappingHandlerAdapter(MarshallingHttpMessageConverter marshallingHttpMessageConverter) {
    RequestMappingHandlerAdapter requestMappingHandlerAdapter = new RequestMappingHandlerAdapter();

    List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
    messageConverters.add(marshallingHttpMessageConverter);

    requestMappingHandlerAdapter.setMessageConverters(messageConverters);

    return requestMappingHandlerAdapter;
}