@Inherited
@JacksonAnnotationsInside
@Retention(RetentionPolicy.RUNTIME)
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property = "@class")
public @interface PolymorphismSupport {

    Class<?> defaultType() default Object.class;

}

public class CustomAnnotationIntrospector extends JacksonAnnotationIntrospector {

    @Override
    protected TypeResolverBuilder<?> _findTypeResolver(MapperConfig<?> config, Annotated ann, JavaType baseType) {
        TypeResolverBuilder<?> b = super._findTypeResolver(config, ann, baseType);
        PolymorphismSupport support = _findAnnotation(ann, PolymorphismSupport.class);
        if (null != b && null != support) {
            b.defaultImpl(support.defaultType());
        }
        return b;
    }
}


public class CustomObjectMapper extends ObjectMapper {

    public CustomObjectMapper() {
        setAnnotationIntrospector(new CustomAnnotationIntrospector());
    }
}