public static boolean hasDestroyMethod(Object bean, RootBeanDefinition beanDefinition) {
        ...
        if (AbstractBeanDefinition.INFER_METHOD.equals(destroyMethodName)) {
            return (ClassUtils.hasMethod(bean.getClass(), CLOSE_METHOD_NAME) ||
                    ClassUtils.hasMethod(bean.getClass(), SHUTDOWN_METHOD_NAME));
        }
        ...
    }