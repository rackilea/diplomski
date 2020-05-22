public aspect ShapeAspect {
    pointcut getDimensions() : execution(* Shape+.getDimensions());
    pointcut getDimensionsNoSuper() : getDimensions() && !cflowbelow(getDimensions());

    after() : getDimensionsNoSuper() {
        System.out.println(thisJoinPointStaticPart);
    }
}