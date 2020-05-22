@Value("${my.header.property.name}")
private String myHeaderPropertyName;

public void someListenerMethod(@Headers
                               final Map<String, Object> headerAttributes) {
    final Long myHeaderAttribute = (Long) headerAttributes.get(myHeaderPropertyName));