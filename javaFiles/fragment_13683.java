@ControllerAdvice
public class CSRFHandler implements ResponseBodyAdvice<Object> {

    @Value("${security.csrf.enabled}")
    private String csrfEnabled;

    @Value("${security.csrf.headerName}")
    private String csrfHeaderName;

    @Value("${security.csrf.salt}")
    private String salt;

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
            Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request,
            ServerHttpResponse response) {

        if (new Boolean(csrfEnabled).booleanValue()) {
            String csrfValue = SecureUtil.buildCsrfValue(salt, StringUtil.toJson(body));
            response.getHeaders().add(csrfHeaderName, csrfValue);
        }

        return body;
    }

}