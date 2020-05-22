@Aspect
public class EntityAuditLogAspect {       

    public EntityAuditLogAspect(/*inject deps here*/) {
    }

    /**
     * On save pointcut.
     */
    @Pointcut("org.springframework.data.repository.Repository+.save(..))")
    public void onSavePointcut() {
    } 

    @Around("onSavePointcut()")
    public Object onSave(ProceedingJoinPoint pjp) throws Throwable {
        final Object[] args = pjp.getArgs();

        final Object before = args[0];
        // load current value from database
        // calculate diff and store it 

        return pjp.proceed();
    } 
}