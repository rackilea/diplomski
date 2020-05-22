public class CacheInitialingProcessor implements BeanPostProcessor, SmartInitializingSingleton {

    private final Set<String> caches = new HashSet<String>();

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Class<?> targetClass = AopUtils.getTargetClass(bean);
        ReflectionUtils.doWithMethods(targetClass, new ReflectionUtils.MethodCallback() {
            @Override
            public void doWith(Method method) throws IllegalArgumentException, IllegalAccessException {
                Cacheable cacheable = AnnotationUtils.getAnnotation(method, Cacheable.class);
                if (cacheable != null) {
                    caches.addAll(Arrays.asList(cacheable.cacheNames()));
                }
            }
        });
        return bean;
    }

    @Override
    public void afterSingletonsInstantiated() {
        for (String cache : caches) {
            // inti caches.
        }
    }
}