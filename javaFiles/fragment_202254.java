@Aspect
@Component
public class MonitorAspect {

    @Around("@annotation(com.company.project.monitor.aspect.Monitored)")
    public Object monitor(ProceedingJoinPoint pjp) throws Throwable {
        MethodSignature signature = (MethodSignature) pjp.getSignature();
        Method method = pjp.getTarget()
           .getClass()
           .getMethod(signature.getMethod().getName(),     
                      signature.getMethod().getParameterTypes());
        Monitored monitored = method.getAnnotation(Monitored.class);
        ...
    }
}