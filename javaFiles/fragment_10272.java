public class SomeHeaderArgumentResolver extends AbstractNamedValueMethodArgumentResolver {
    @Override
    protected NamedValueInfo createNamedValueInfo(MethodParameter parameter) {
        // The second parameter specifies if the value is required, 
        // and the third if there is some default value.
        return new NamedValueInfo("", true, null);
    }

    @Override
    protected Object resolveName(String name, 
                                 MethodParameter parameter, 
                                 NativeWebRequest request) {
        final String headerValue = request.getHeader("Some-Value");
        if (StringUtils.isEmpty(headerValue)) {
            // Returning null tells Spring that there is no value for the parameter
            return null;
        }
        return headerValue.replace("XXX ", "");
    }

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return (parameter.hasParameterAnnotation(SomeHeader.class) &&
                !Map.class.isAssignableFrom(
                    parameter.nestedIfOptional().getNestedParameterType()));
    }
}