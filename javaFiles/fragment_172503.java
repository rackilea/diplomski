@Around("@annotation(MyAnnotation)")
public Object advice(ProceedingJoinPoint pjp) throws Throwable {
    Method method = ((MethodSignature) pjp.getSignature()).getMethod();
    Type[] genericParamsClass = method.getGenericParameterTypes();

    logger.info(((ParameterizedType) genericParamsClass[0]).getActualTypeArguments()[0]);
    ...
}