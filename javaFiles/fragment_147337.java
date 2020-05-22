@Interceptor
@Entitled
public class EntitledInterceptor {
    @AroundInvoke
    public void interceptOrder(InvocationContext ctx) {
        // return type is AccountDetails 
        // parameter[0] is acccoundId
        Permission p = new CustomPermission(context.getMethod().getReturnType(),
                                            ctx.getParameters()[0]);
        if(SecurityUtils.getSubject().isPermitted(p)){
          return ctx.proceed();
        } else {
         throw new RowLevelSecurityException("No access!");
        }
}