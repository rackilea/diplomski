class MyInterceptor {
    public Object invoke(MethodInvocation mi) {
        if(mi.getMethod().getAnnotation(MyAnnotationClass.class) != null) {
            // Do the interception
        }
        else {
            return mi.proceed();
        }
    }
}