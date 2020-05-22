private static class ExposeBeanNameInterceptor implements MethodInterceptor {

    private final String beanName;

    public ExposeBeanNameInterceptor(String beanName) {
        this.beanName = beanName;
    }

    public Object invoke(MethodInvocation mi) throws Throwable {
        if (!(mi instanceof ProxyMethodInvocation)) {
            throw new IllegalStateException("MethodInvocation is not a Spring ProxyMethodInvocation: " + mi);
        }
        ProxyMethodInvocation pmi = (ProxyMethodInvocation) mi;
        pmi.setUserAttribute(BEAN_NAME_ATTRIBUTE, this.beanName);
        return mi.proceed();
    }
}