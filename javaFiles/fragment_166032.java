public static class ConfigInjectionResolver implements InjectionResolver<Config> {

    private static final Map<String, String> properties = new HashMap<>();

    public ConfigInjectionResolver() {
        properties.put("greeting.message", "Hello World");
    }

    @Override
    public Object resolve(Injectee injectee, ServiceHandle<?> handle) {
        if (String.class == injectee.getRequiredType()) {
            AnnotatedElement elem = injectee.getParent();
            if (elem instanceof Constructor) {
                Constructor ctor = (Constructor) elem;
                Config config = (Config) ctor.getParameterAnnotations()[injectee.getPosition()][0];
                return properties.get(config.value());
            } else {
                Config config = elem.getAnnotation(Config.class);
                return properties.get(config.value());
            }
        }
        return null;
    }

    @Override
    public boolean isConstructorParameterIndicator() { return true; }

    @Override
    public boolean isMethodParameterIndicator() { return false; }
}