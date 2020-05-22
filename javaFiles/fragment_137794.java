@AroundInvoke
public Object defaultInterceptor(InvocationContext ctx) throws Exception
{
   Object[] parameters = ctx.getParameters();

   /* parameters will have values that will be 
      passed to the method of the target class */

   return ctx.proceed();
}