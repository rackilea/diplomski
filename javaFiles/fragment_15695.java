public aspect ExecutionTimingAspect {
    private String indentText = "";

    pointcut constructorCall() :
        call(*Application*.new(..));

    pointcut constructorRelated() :
        constructorCall() ||
        initialization(*Application*.new(..)) ||
        preinitialization(*Application*.new(..)) ||
        execution(*Application*.new(..));

    after() : constructorRelated() {
        indentText = indentText.substring(2);
        System.out.println(indentText + "<< " + thisJoinPointStaticPart);
    }

    before() : constructorRelated() {
        System.out.println(indentText + ">> " + thisJoinPointStaticPart);
        indentText += "  ";
    }

    Object around() : constructorCall() {
        long startTime = System.nanoTime();
        Object result = proceed();
        System.out.println(indentText + "Constructor runtime = " + (System.nanoTime() - startTime) / 1.0e9 + " s\n");
        return result;
    }
}