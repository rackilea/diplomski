protected void injectDependencies(final TestContext testContext)
throws Exception {
    Object bean = testContext.getTestInstance();
    AutowireCapableBeanFactory beanFactory = testContext.getApplicationContext()
            .getAutowireCapableBeanFactory();
    beanFactory.autowireBeanProperties(bean, 

            AutowireCapableBeanFactory.AUTOWIRE_NO,
            // no autowiring!!!!!!!!

            false
        );

    beanFactory.initializeBean(bean, testContext.getTestClass().getName());
    // but here, bean post processors are run

    testContext.removeAttribute(REINJECT_DEPENDENCIES_ATTRIBUTE);
}