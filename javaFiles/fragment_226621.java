@Component
public class CustomBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {

    @Override
    public void postProcessBeanDefinitionRegistry(
            BeanDefinitionRegistry registry) throws BeansException {

          // this method can be used to set a primary bean, although 
          // beans defined in a @Configuration class will not be avalable here.

    }

    @Override
    public void postProcessBeanFactory(
            ConfigurableListableBeanFactory beanFactory) throws BeansException {     

        // here, all beans are available including those defined by @configuration, @component, xml, etc.

        // do some magic to somehow find which is the preferred bean name for each interface 
        // you have access to all bean-definition names with: beanFactory.getBeanDefinitionNames()
        String beanName = "aImpl2"; // let's say is this one

        // get the definition for that bean and set it as primary
        beanFactory.getBeanDefinition(beanName).setPrimary(true)

    }



}