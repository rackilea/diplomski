@Override
public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
    final ByteArrayHttpMessageConverter arrayHttpMessageConverter = new ByteArrayHttpMessageConverter();
    final List<MediaType> list = new ArrayList<>();
    list.add(MediaType.IMAGE_JPEG);
    list.add(MediaType.APPLICATION_OCTET_STREAM);
    arrayHttpMessageConverter.setSupportedMediaTypes(list);
    converters.add(arrayHttpMessageConverter);

    super.configureMessageConverters(converters);
}