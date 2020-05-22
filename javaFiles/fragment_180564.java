@Aspect
class MyAspect {
    @Pointcut("execution(* *(..)) && @annotation(l)")
    public void invoke(Logged l) {}

    @Around("invoke(l)")
    public void aspectMethod (ProceedingJoinPoint pjp, Logged l) {
        java.lang.System.out.println(l.event()+" "+l.system());
    }
}