@Configuration
public class ConfigurationInModule2 {

    @Bean
    public static BeanFactoryPostProcessor dependencyBeanFactoryPostProcessor() {
        return new JBCDependencyBeanFactoryPostProcessor();
    }

    @Bean
    public SomeBeanForModule2 beanForModule2(FirstBean firstBean) {
        return new SomeBeanForModule2(firstBean);
    }
}