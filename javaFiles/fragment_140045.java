public class CustomAlpsJsonHttpMessageConverter extends AlpsJsonHttpMessageConverter {

    public CustomAlpsJsonHttpMessageConverter(RootResourceInformationToAlpsDescriptorConverter converter) {
        super(converter);
    }

    @Override
    public boolean canWrite(Class<?> clazz, MediaType mediaType) {
        return super.canWrite(clazz, mediaType);
    }

    @Override
    public boolean canRead(Type type, Class<?> contextClass, MediaType mediaType) {
        return super.canRead(type, contextClass, mediaType);
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
            Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request,
            ServerHttpResponse response) {
        return super.beforeBodyWrite(body, returnType, selectedContentType, selectedConverterType, request, response);
    }

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return converterType.equals(AlpsJsonHttpMessageConverter.class) 
                || converterType.equals(CustomAlpsJsonHttpMessageConverter.class);
    }

}