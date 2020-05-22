public aspect MethodArgsAspect {
    pointcut allMethods()      : execution(* *(..));
    pointcut allConstructors() : execution(*.new(..));

    before() : !within(MethodArgsAspect) && (allMethods() || allConstructors()) {
        System.out.println(thisJoinPointStaticPart.getSignature());
        for (Object arg : thisJoinPoint.getArgs())
            System.out.println("    " + arg);
    }
}