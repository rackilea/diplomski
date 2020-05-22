@RequiredArgsConstructor
public class SessionMethodInterceptor implements MethodInterceptor {     
private final Object originalBean;

        @Override
        public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
           // * args' changes *
            return method.invoke(originalBean, args);
        }