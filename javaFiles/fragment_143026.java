BeanDefinitionRegistry registry = (BeanDefinitionRegistry) beanFactory;
BeanDefinition beanDefinition = registry.getBeanDefinition(beanName);
if (beanDefinition instanceof AnnotatedBeanDefinition) {
    if (beanDefinition.getSource() instanceof MethodMetadata) {
        MethodMetadata beanMethod = (MethodMetadata) beanDefinition.getSource();
        String annotationType = UserDetails.class.getName();
        if (beanMethod.isAnnotated(annotationType)) {
    ...