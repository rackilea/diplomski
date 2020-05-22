public class OnApiVersionConditional implements Condition {

@Override
public boolean matches(final ConditionContext context, final AnnotatedTypeMetadata metadata) {

    final MultiValueMap<String, Object> attributes = metadata
            .getAllAnnotationAttributes(ConditionalOnApiVersion.class.getName());

    // 1.  Retrieve the property name from the annotation (i.e. userInputVersion)
    List<Object> propertyObject = attributes.get("property");
    // 2.  Cast it to a String
    String propertyName = (String)propertyObject.get(0);

    // 3.  Retrieve the value 
    List<Object> list = attributes.get("value");
    // 4.  Cast it to int[]
    int[] values = (int[])list.get(0);

    // 5.  Look up the actual version (based on the property name in the annotation)
    final String inputVersion = context.getEnvironment().getProperty(propertyName);
    // Assume it is an integer? 
    int version = Integer.valueOf(inputVersion).intValue();

    // 6.  Scan the supported version; look to match against actual version
    for (int i : values)
        if (i == version)
            return true;

    // The version is not supported
    return false;

}

}