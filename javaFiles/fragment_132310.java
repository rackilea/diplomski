public static <T> FactoryBean<T> preventAutowire(T bean) {
    return new FactoryBean<T>() {
        public T getObject() throws Exception {
            return bean;
        }

        public Class<?> getObjectType() {
            return bean.getClass();
        }

        public boolean isSingleton() {
            return true;
        }
    };
}

...

@Bean
static FactoryBean<MyBean> myBean() {
    return preventAutowire(new MyBean());
}