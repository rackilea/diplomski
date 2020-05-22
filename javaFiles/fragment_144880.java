@Around("execution(public * org.springframework.data.jpa.repository.JpaRepository+.*(..))")
    // @Around("@annotation(Repository)")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        CreateNode createNode = method.getAnnotation(CreateNode.class);
        if(createNode != null) {
            Object[] args = joinPoint.getArgs();
            // do your business

        }
        return joinPoint.proceed();
    }