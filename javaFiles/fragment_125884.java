@Configuration
public class WebMvcConfiguration extends WebMvcConfigurationSupport {
    @Override
    protected ConfigurableWebBindingInitializer getConfigurableWebBindingInitializer() {
        final ConfigurableWebBindingInitializer initializer = super.getConfigurableWebBindingInitializer();
        initializer.setDirectFieldAccess(true);
        return initializer;
    }
}