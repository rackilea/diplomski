@Pointcut("@annotation(log)")
public void logPointcut(com.skyfall.aspects.Log log) {}

@Before("logPointcut(log))")
public void logBefore(JoinPoint joinPoint, com.skyfall.aspects.Log log) {
    System.out.println(log.id());
}