private static final ThreadLocal<RequestAttributes> requestAttributesHolder = 
      new NamedThreadLocal<RequestAttributes>("Request attributes");

public static RequestAttributes getRequestAttributes() {
    RequestAttributes attributes = requestAttributesHolder.get();
    if (attributes == null) {
        attributes = inheritableRequestAttributesHolder.get();
    }
    return attributes;
}