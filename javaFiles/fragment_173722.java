public class ConfiguredServiceBean implements Bean<ConfiguredService>, PassivationCapable {


    static Set<Type> types;
    private final Configuration configuration;
    private final Set<Annotation> qualifiers = new HashSet<>();

    public ConfiguredServiceBean(Configuration configuration) {
        this.configuration = configuration;
        qualifiers.add(configuration);
        qualifiers.add(new AnnotationLiteral<Any>() {
        });
    }

    @Override
    public Class<?> getBeanClass() {
        return ConfiguredService.class;
    }

    @Override
    public Set<InjectionPoint> getInjectionPoints() {
        return Collections.EMPTY_SET;
    }

    @Override
    public boolean isNullable() {
        return false;
    }

    @Override
    public Set<Type> getTypes() {
        return types;
    }

    @Override
    public Set<Annotation> getQualifiers() {
        return qualifiers;
    }

    @Override
    public Class<? extends Annotation> getScope() {
        return ApplicationScoped.class;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public Set<Class<? extends Annotation>> getStereotypes() {
        return Collections.EMPTY_SET;
    }

    @Override
    public boolean isAlternative() {
        return false;
    }

    @Override
    public ConfiguredService create(CreationalContext<ConfiguredService> creationalContext) {
        return new ConfiguredService(configuration.value());
    }

    @Override
    public void destroy(ConfiguredService instance, CreationalContext<ConfiguredService> creationalContext) {
    }

    @Override
    public String getId() {
        return getClass().toString() + configuration.value();
    }
}