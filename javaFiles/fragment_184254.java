@Aspect
public class AnyAspectName {

    @Pointcut("execution(@X * *.*(..))")
    void annotatedMethod() {}

    @Pointcut("execution(* (@X *).*(..))")
    void methodOfAnnotatedClass() {}

    @Around("annotatedMethod() && @annotation(methodLevelX)")
    public Object adviseAnnotatedMethods(ProceedingJoinPoint pjp, X methodLevelX) 
            throws Throwable {
        return aroundImplementation(pjp, methodLevelX);
    }

    @Around("methodOfAnnotatedClass() && !annotatedMethod() && @within(classLevelX)")
    public Object adviseMethodsOfAnnotatedClass(ProceedingJoinPoint pjp, X classLevelX) 
            throws Throwable {
        return aroundImplementation(pjp, classLevelX);
    }

    public Object aroundImplementation(ProceedingJoinPoint pjp, X annotation) 
            throws Throwable {
        return pjp.proceed();
    }

}