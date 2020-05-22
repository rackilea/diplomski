@Produces
@Config
public Configuration produce(InjectionPoint ip) {
    if (config == null) {
        config = ConfigFactory.create(Configuration.class);        
    }
    return config;
}