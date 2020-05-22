@Pointcut("execution(* my.stuff..*(..))")
private void allMethods() {
}

@Pointcut("@within(myAnnotation)")
private void myAnnotations(MyAnnotation myAnnotation) {
}

@Pointcut("allMethods() && myAnnotations(myAnnotation)")
private void myAnnotatedClassMethods(MyAnnotation myAnnotation) {
}

@Before("myAnnotatedClassMethods(myAnnotation)")
private void beforeMyAnnotatedClassMethods(MyAnnotation myAnnotation){
    System.out.println("my annotated class method detected: " + myAnnotation);
}