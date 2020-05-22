@ControllerAdvice
public class ResourceSizeAdvice implements ResponseBodyAdvice<Collection<?>> {

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        //Checks if this advice is applicable. 
        //In this case it applies to any endpoint which returns a collection.
        return Collection.class.isAssignableFrom(returnType.getParameterType()); 
    }

    @Override
    public Collection<?> beforeBodyWrite(Collection<?> body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        response.getHeaders().add("X-Total-Count", String.valueOf(body.size()));
        return body;
    }
}