@Aspect
public class NotificationAspect
{
   ...
   @AfterThrowing(pointcut="@annotation(com.integration.core.meta.NotifyOnFailure)", throwing="ex")
   public void executeOnException(JoinPoint joinPoint, ExternalApiExecutionException ex) throws Throwable
    {
    ...