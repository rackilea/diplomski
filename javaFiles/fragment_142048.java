package misc.app.security;

import javax.interceptor.AroundConstruct;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;


/**
 * An interceptor for declarative security checks using the annotations from the 
 * {@code org.apache.shiro.authz.annotation} package.
 *
 */
@ShiroSecured @Interceptor
public class ShiroSecuredInterceptor extends AnnotationsAuthorizingConstructorInterceptor {

    @AroundConstruct
    public Object checkAuthorization(final InvocationContext ic) throws Exception {
        assertAuthorized(new InvocationContextToConstructorInvocationConverter(ic));

        return ic.proceed();
    }

    private static class InvocationContextToConstructorInvocationConverter implements ConstructorInvocation {

        private final InvocationContext context;


        public InvocationContextToConstructorInvocationConverter(InvocationContext ic) {
            context = ic;
        }

        @Override
        public Object proceed() throws Throwable {
            return context.proceed();
        }

        @Override
        public Class getClazz() {
            return context.getConstructor().getDeclaringClass();
        }
    }   
}