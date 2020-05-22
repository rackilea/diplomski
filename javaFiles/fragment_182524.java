public class ValidationConfigurationContextResolver 
        implements ContextResolver<ValidationConfig> {

    @Override
    public ValidationConfig getContext(final Class<?> type) {
        ValidationConfig config = new ValidationConfig();
        config.parameterNameProvider(new CustomParameterNameProvider());
        return config;
    }
}