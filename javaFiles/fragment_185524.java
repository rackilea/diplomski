@ControllerAdvice(basePackages = "package.where.all.my.controllers.are")
public class JSONResponseWrapper implements ResponseBodyAdvice {
    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return true;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        if (body instanceof List) {
            return new Wrapper<>((List<Object>) body);
        }
        return body;
    }

    @Data // just the lombok annotation which provides getter and setter
    private class Wrapper<T> {
        private final List<T> list;

        public Wrapper(List<T> list) {
            this.list = list;
        }
    }
}