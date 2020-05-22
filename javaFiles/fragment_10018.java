@Component
public class OaliaBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @SuppressWarnings("unchecked")
    public void postProcessBeanFactory(
            ConfigurableListableBeanFactory beanFactory) throws BeansException {
        for(String beanName : beanFactory.getBeanDefinitionNames())
        {
            //Scope resolution
            BeanDefinition beanDefinition = beanFactory.getBeanDefinition(beanName);
            Class beanClass= null;
            try {
                beanClass = Class.forName(beanDefinition.getBeanClassName());
            } catch (ClassNotFoundException e) {
                // exception handling goes here
            }
            if (Command.class.isAssignableFrom(beanClass))
                beanDefinition.setScope("prototype");

            //Stuff that the BeanPostProcessor do go here
            //..........
            //..........

            System.out.println("[Post Processing] " + beanName + " [" + beanDefinition.getScope() + "]");
        }
        }
    }