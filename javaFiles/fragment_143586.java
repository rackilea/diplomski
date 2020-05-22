List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
marshaller.setClassesToBeBound(ResponseObject.class);
MarshallingHttpMessageConverter marshallingHttpMessageConverter = new MarshallingHttpMessageConverter(marshaller, marshaller);
marshallingHttpMessageConverter.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON, MediaType.TEXT_HTML));
messageConverters.add(marshallingHttpMessageConverter);
restTemplate.setMessageConverters(messageConverters);