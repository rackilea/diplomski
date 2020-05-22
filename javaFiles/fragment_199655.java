public class SecurityGuard implements MethodInterceptor {
    @Inject private Provider<Application> application;

    public Object invoke(MethodInvocation invocation) throws Throwable {
       AllowedRoles allowedRoles = invocation.getMethod().getAnnotation(AllowedRoles.class);
        if (((User) application.get().getUser()).hasRole(allowedRoles.value())) {
            return invocation.proceed(); 
        } else {
            return null;
        }
}