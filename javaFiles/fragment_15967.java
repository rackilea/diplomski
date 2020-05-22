public class MyInterceptionService implements InterceptionService {

    private final static MethodInterceptor METHOD_INTERCEPTOR 
            = new MyMethodInterceptor();
    private final static List<MethodInterceptor> METHOD_LIST
            = Collections.singletonList(METHOD_INTERCEPTOR);

    @Override
    public Filter getDescriptorFilter() {
        return BuilderHelper.allFilter();
    }

    @Override
    public List<MethodInterceptor> getMethodInterceptors(Method method) {
        // you implement shouldIntercept
        if (shouldIntercept(method)) {
            return METHOD_LIST;
        }
        return null;
    }

    @Override
    public List<ConstructorInterceptor> getConstructorInterceptors(Constructor<?> constructor) {
        return null;
    }
}