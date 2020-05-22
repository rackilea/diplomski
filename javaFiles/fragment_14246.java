public aspect LogTimeAspect {
    pointcut publicMethod() : execution(public * *(..));

    before(LogExecutionTime logAnn) : publicMethod() && @annotation(logAnn) {
        System.out.println(thisJoinPointStaticPart + " -> " + logAnn.level());
    }

    before(LogExecutionTime logAnn) : publicMethod() && @within(logAnn) {
        System.out.println(thisJoinPointStaticPart + " -> " + logAnn.level());
    }
}