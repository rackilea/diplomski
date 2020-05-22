@Bean
AbstractAutoProxyCreator autoProxyCreator() {
    return new AbstractAutoProxyCreator() {
        @Override 
        protected Object[] getAdvicesAndAdvisorsForBean(Class<?> beanClass, String beanName, TargetSource customTargetSource) {
            if (BusinessService.class.isAssignableFrom(beanClass)) {
                return new Object[] {loggingAdvice()};
            } else {
                return DO_NOT_PROXY;
            }
        }
    };
}

@Bean
LoggingAdvice loggingAdvice() {
    return new LoggingAdvice();
}

@Bean
public PersonService personService() {
    return new PersonService();
}