public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (classesWithAnnotatedMethods.get(beanName) != null) {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(bean.getClass());
            enhancer.setCallback(new SessionMethodInterceptor(bean));
            return enhancer.create();
        }
        return bean;
    }