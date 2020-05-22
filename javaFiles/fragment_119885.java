@Before("execution(* com.foo.bar.*.doStuff(..)) && args(arg1, arg2)")
    public void logSomething(JoinPoint jp, CustomObject arg1, Object arg2) throws Throwable {

        MethodSignature methodSignature = (MethodSignature) jp.getSignature();
        Class<?> clazz = methodSignature.getDeclaringType();
        Method method = clazz.getDeclaredMethod(methodSignature.getName(), methodSignature.getParameterTypes());
        SomeAnnotation argumentAnnotation;
        for (Annotation ann : method.getParameterAnnotations()[0]) {
            if(SomeAnnotation.class.isInstance(ann)) {
                argumentAnnotation = (SomeAnnotation) ann;
                System.out.println(argumentAnnotation.value());
            }
        }
    }