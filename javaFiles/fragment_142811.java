interface Context {
    BeanFactory getBeanFactory(); // public method
    void refresh(); // public method
    void destroy(); // public method
}

interface BeanFactory {
    <T> T getBean(String id); // public method
}

interface DestroyableBeanFactory extends BeanFactory {
    void destroyBeans(); // should be private method for user, but visible for Context
}

class ContextImpl implements Context {
    private DestroyableBeanFactory beanFactory;

    // internally we demand a DestroyableBeanFactory but we only
    // expose it as BeanFactory
    public BeanFactory getBeanFactory() {
        return beanFactory;
    }
    @Override
    public void destroy() {
        beanFactory.destroyBeans();
    }
}