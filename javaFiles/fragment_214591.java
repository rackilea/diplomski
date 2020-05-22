@AroundInvoke
public Object intercept( InvocationContext ctx )
{
  try
  {
    init();
    return ctx.proceed();
  }
  finally
  {
    release();
  }
}