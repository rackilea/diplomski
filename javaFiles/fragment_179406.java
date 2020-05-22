class JsonObjectPropertyResolver implements HandlerMethodArgumentResolver {
    /**
     * Configured as appropriate for the JSON you expect.
     */
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(JsonObjectProperty.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest,
            WebDataBinderFactory binderFactory) throws Exception {
        Class<?> parameterType = parameter.getParameterType();

        HttpServletRequest servletRequest = webRequest.getNativeRequest(HttpServletRequest.class);
        ServletServerHttpRequest inputMessage = new ServletServerHttpRequest(servletRequest);
        MediaType contentType = inputMessage.getHeaders().getContentType();
        if (!contentType.equals(MediaType.APPLICATION_JSON_UTF8)) {
            throw new HttpMessageNotReadableException(
                    "Could not read document. Expected Content-Type " + MediaType.APPLICATION_JSON_UTF8 + ", was " + contentType + ".");
        }
        // handle potential exceptions from this as well
        ObjectNode rootObject = objectMapper.readValue(inputMessage.getBody(), ObjectNode.class);
        if (parameterType == String.class) {
            JsonObjectProperty annotation = parameter.getParameterAnnotation(JsonObjectProperty.class);
            return rootObject.get(annotation.name()).asText();
        }
        // handle more
        throw new HttpMessageNotReadableException("Could not read document. Parameter type " + parameterType + " not parseable.");
    }
}