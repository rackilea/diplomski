@Produces
@ConfigurableQualifier
public MyBean configurableProducer(InjectionPoint ip){
    int somePropertyValue = ip.getAnnotated().getAnnotation(ConfigurableQualifier.class).value();
    return new MyBean(somePropertyValue);
}