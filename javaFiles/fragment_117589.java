@Before("handler(*) && args(e)")
public void logCaughtException(
    JoinPoint thisJoinPoint,
    JoinPoint.EnclosingStaticPart thisEnclosingJoinPointStaticPart,
    Exception e
) {
    // Exception handler
    System.out.println(thisJoinPoint.getSignature() + " -> " + e);

    // Method signature + parameter types/names
    MethodSignature methodSignature = (MethodSignature) thisEnclosingJoinPointStaticPart.getSignature();
    System.out.println("    " + methodSignature);
    Class<?>[] paramTypes = methodSignature.getParameterTypes();
    String[] paramNames = methodSignature.getParameterNames();
    for (int i = 0; i < paramNames.length; i++)
        System.out.println("      " + paramTypes[i].getName() + " " + paramNames[i]);

    // Method annotations - attention, reflection!
    Method method = methodSignature.getMethod();
    for (Annotation annotation: method.getAnnotations())
        System.out.println("    " + annotation);
}