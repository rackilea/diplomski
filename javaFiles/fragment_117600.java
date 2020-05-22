public class DefaultFiltersBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory bf)
        throws BeansException {
        DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory)bf;

        Arrays.stream(beanFactory.getBeanNamesForType(javax.servlet.Filter.class))
              .forEach(
                  name -> {
                      BeanDefinition definition =
                          BeanDefinitionBuilder.genericBeanDefinition(FilterRegistrationBean.class)
                                               .setScope(BeanDefinition.SCOPE_SINGLETON)
                                               .addConstructorArgReference(name)
                                               .addConstructorArgValue(new ServletRegistrationBean[] {})
                                               .addPropertyValue("enabled", false)
                                               .getBeanDefinition();

                      beanFactory.registerBeanDefinition(name + "FilterRegistrationBean", definition);
                  });
    }
}