@Component
public class BeanDefinitionRegistryPP implements BeanDefinitionRegistryPostProcessor, EnvironmentAware {
     private Environment env;

     @Override
     public void setEnvironment(Environment environment) {
        this.env=environment;
     }

     @Override
     public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
         GenericBeanDefinition beanDefinition= new GenericBeanDefinition();
         beanDefinition.setBeanClass(MyBean.class);
         registry.registerBeanDefinition(env.getProperty("bean.name"), beanDefinition);
     }

     @Override
     public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        // no code
     }
}