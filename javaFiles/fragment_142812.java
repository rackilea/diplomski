class ContextImpl implements Context {
    private DestroyableBeanFactory beanFactory;

    // to be extra safe, we create a read-only wrapper
    // for our bean factory
    public BeanFactory getBeanFactory() {
        return new BeanFactory() { //written as an anon inner class for brevity, ideally you should cache this read-only wrapper instance
             public <T> T getBean(String id) { 
                 return beanFactory.getBean(id);
             }
        };
    }
    ...
  }