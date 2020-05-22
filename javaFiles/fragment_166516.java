public class AutoMockBeanFactory extends DefaultListableBeanFactory {

    @Override
    protected Map<String, Object> findAutowireCandidates(final String beanName, final Class<?> requiredType, final DependencyDescriptor descriptor) {
        String mockBeanName = Introspector.decapitalize(requiredType.getSimpleName()) + "Mock";
        Map<String, Object> autowireCandidates = new HashMap<>();
        try {
            autowireCandidates = super.findAutowireCandidates(beanName, requiredType, descriptor);
        } catch (UnsatisfiedDependencyException e) {
            if (e.getCause() != null && e.getCause().getCause() instanceof NoSuchBeanDefinitionException) {
                mockBeanName = ((NoSuchBeanDefinitionException) e.getCause().getCause()).getBeanName();
            } 
            this.registerBeanDefinition(mockBeanName, BeanDefinitionBuilder.genericBeanDefinition().getBeanDefinition());
        }
        if (autowireCandidates.isEmpty()) {
            final Object mock = mock(requiredType);
            autowireCandidates.put(mockBeanName, mock);
            this.addSingleton(mockBeanName, mock);
        }
        return autowireCandidates;
    }
}