public class ConfigResourcesEnvironment extends AbstractConfigResourcesFactoryBean implements ServletContextAware, 
    ResourceLoaderAware, EnvironmentAware, BeanDefinitionRegistryPostProcessor {

    private Environment environment;

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        if (environment instanceof ConfigurableEnvironment) {
            ConfigurableEnvironment env = ((ConfigurableEnvironment) this.environment);
            List<ResourcePropertySource> propertyFiles;
            try {
                propertyFiles = getResourcePropertySources();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            //Spring prefers primacy ordering so we reverse the order of the files.
            reverse(propertyFiles);
            for (ResourcePropertySource rp : propertyFiles) {
                env.getPropertySources().addLast(rp);
            }
        }
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        //NOOP
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }


}