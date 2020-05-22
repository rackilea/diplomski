public class RefCacheKeyGenerator implements org.springframework.cache.interceptor.KeyGenerator {

    @Override
    public Object generate(Object target, Method method, Object... params) {
        final List<Object> key = new ArrayList<>();

        key.add(method.getDeclaringClass().getName());      
        key.add(method.getName());

        List<Class<?>> clazz = ClassUtils.getAllInterfaces(target.getClass());
        if(CollectionUtils.isNotEmpty(clazz)){
            for(Class<?> sClass : clazz){
                if(AbstractReferenceService.class.isAssignableFrom(sClass)){
                    if(!AbstractReferenceService.class.equals(sClass)){
                     key.add(sClass.getName());
                    }
                }
            }
        }
        for (final Object o : params) {
            key.add(o);
        }

        return key;
    }

}