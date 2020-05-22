public class RoleBeanDefinitionConfigurer implements BeanDefinitionRegistryPostProcessor {

    private String[] beanNames;

    @Override
    public void postProcessBeanFactory(
            ConfigurableListableBeanFactory beanFactory) throws BeansException {

    }

    @Override
    public void postProcessBeanDefinitionRegistry(
            BeanDefinitionRegistry registry) throws BeansException {

        if (beanNames == null)
            return;

        for (String name : beanNames) {
            if (registry.containsBeanDefinition(name))
                ((AbstractBeanDefinition) registry.getBeanDefinition(name)).setRole(BeanDefinition.ROLE_INFRASTRUCTURE);
        }
    }

    public String[] getBeanNames() {
        return beanNames;
    }

    public void setBeanNames(String[] beanNames) {
        this.beanNames = beanNames;
    }

}