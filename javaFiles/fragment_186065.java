public void removeExistingAndAddNewBean(String beanId) {

   AutowireCapableBeanFactory factory = 
                   applicationContext.getAutowireCapableBeanFactory();
   BeanDefinitionRegistry registry = (BeanDefinitionRegistry) factory;
   registry.removeBeanDefinition(beanId);

    //create newBeanObj through GenericBeanDefinition

    registry.registerBeanDefinition(beanId, newBeanObj);
}