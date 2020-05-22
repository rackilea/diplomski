@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public static @interface Config {
    String value();
}

public class ConfigInjectionResolver implements InjectionResolver<Config> {

    private final Properties properties;
    public ConfigurationInjectionResolver(Properties properties) {
        this.properties = properties;
    }

    @Override
    public Object resolve(Injectee injectee, ServiceHandle<?> handle) {
        if (String.class == injectee.getRequiredType()) {
            Config annotation = injectee.getParent().getAnnotation(Config.class);
            if (annotation != null) {
                String prop = annotation.value();
                return properties.getProperty(prop);
            }
        }
        return null;
    }
    ...
}

final Properties props...
resourceConfig.register(new AbstractBinder(){
    @Override
    protected void configure() {
        bind(new ConfigInjectResolver(props))
                .to(new TypeLiteral<InjectionResolver<Config>>(){});
    }
});