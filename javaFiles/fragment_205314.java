public static class MockProcessor implements BeanPostProcessor {
         : 
         :
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (/* distinguish your target bean */) 
            return Mockito.mock(FooService.class);
        return bean;
    }
}